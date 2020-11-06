package com.cgi.d4g.business;

/*
 * class to manage the business of scoring.
 */

import com.cgi.d4g.business.model.RegionDigitalScoringModel;
import com.cgi.d4g.business.model.ScoringResultModel;
import com.cgi.d4g.dao.*;
import com.cgi.d4g.entity.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

public class Scoring {

	/** constant used in the calculation */
    private static final BigDecimal BIG_DECIMAL_100 = BigDecimal.valueOf(100);

	/**
     * The department DAO.
     */
    private final DepartmentDAO departmentDAO;

    /**
     * The region DAO.
     */
    private final RegionDAO regionDAO;

    /**
     * The city digital scoring DAO.
     */
    private final CityDigitalScoringDAO cityDigitalScoringDAO;

    /**
     * The department digital scoring DAO.
     */
    private final DepartmentDigitalScoringDAO departmentDigitalScoringDAO;

    /**
     * The filosofi department DAO.
     */
    private final ImpBaseCcFilosofiDepartementDAO impBaseCcFilosofiDepartementDAO;

    /**
     * The filosofi region DAO.
     */
    private final ImpBaseCcFilosofiRegionDAO impBaseCcFilosofiRegionDAO;

    /**
     * The population file DAO.
     */
    private final ImpBaseIcEvolStructPropDAO impBaseIcEvolStructPropDAO;

    /**
     * The filosofie file DAO.
     */
    private final ImpBaseCcFilosofieDAO impBaseCcFilosofieDAO;

    /**
     * The couplesFamillesMenage file DAO.
     */
    private final ImpBaseIcCouplesFamillesMenagesDAO impBaseIcCouplesFamillesMenagesDAO;

    /**
     * The baseIcDiplomesFormation file DAO.
     */
    private final ImpBaseIcDiplomesFormationDAO impBaseIcDiplomesFormationDAO;

    /**
     * The hdThdDeploiement file DAO.
     */
    private final ImpHdThdDeploiementDAO impHdThdDeploiementDAO;

    /**
     * The hdThdDeploiement file DAO.
     */
    private final ImpMetropoleSitesDAO impMetropoleSitesDAO;

    /**
     * Constructor
     *
     * @param regionDAO     the region DAO
     * @param departmentDAO the department DAO
     */
    public Scoring(RegionDAO regionDAO, DepartmentDAO departmentDAO,
		   CityDigitalScoringDAO cityDigitalScoringDAO, DepartmentDigitalScoringDAO departmentDigitalScoringDAO,
		   ImpBaseCcFilosofiDepartementDAO impBaseCcFilosofiDepartementDAO,
		   ImpBaseIcEvolStructPropDAO impBaseIcEvolStructPropDAO,
		   ImpBaseCcFilosofieDAO impBaseCcFilosofieDAO,
		   ImpBaseIcCouplesFamillesMenagesDAO impBaseIcCouplesFamillesMenagesDAO,
		   ImpBaseIcDiplomesFormationDAO impBaseIcDiplomesFormationDAO,
		   ImpHdThdDeploiementDAO impHdThdDeploiementDAO,
		   ImpMetropoleSitesDAO impMetropoleSitesDAO,
		   ImpBaseCcFilosofiRegionDAO impBaseCcFilosofiRegionDAO) {
        this.regionDAO = regionDAO;
        this.departmentDAO = departmentDAO;
        this.cityDigitalScoringDAO = cityDigitalScoringDAO;
        this.departmentDigitalScoringDAO = departmentDigitalScoringDAO;
        this.impBaseCcFilosofiDepartementDAO = impBaseCcFilosofiDepartementDAO;
        this.impBaseIcEvolStructPropDAO = impBaseIcEvolStructPropDAO;
        this.impBaseCcFilosofieDAO = impBaseCcFilosofieDAO;
        this.impBaseIcCouplesFamillesMenagesDAO = impBaseIcCouplesFamillesMenagesDAO;
        this.impBaseIcDiplomesFormationDAO= impBaseIcDiplomesFormationDAO;
        this.impHdThdDeploiementDAO= impHdThdDeploiementDAO;
        this.impMetropoleSitesDAO= impMetropoleSitesDAO;
        this.impBaseCcFilosofiRegionDAO=impBaseCcFilosofiRegionDAO;
    }

    /**
     * Compute the scoring for a city
     *
     * @param city the city where the scoring is requested.
     */
    @Transactional
    public ScoringResultModel getOrRetrieveScoring(City city) {
        Department department = getDepartment(city);
        Region region = getRegion(department);

        RegionDigitalScoringModel regionDigitalScoring = generateRegionDigitalScoring();
        //if empty calulate and save.
        Optional<DepartmentDigitalScoring> departmentDigitalScoring = getDepartmentScoring(department);
        //if empty calulate and save.
        Optional<CityDigitalScoring> cityDigitalScoring = getCityScoring(city);
        //if empty calulate and save.

        return new ScoringResultModel(city, cityDigitalScoring.orElse(calculateCityScoring(city)), department, departmentDigitalScoring.orElse(calculateDepartmentScoring(department)), region, regionDigitalScoring);
    }

    /**
     * Retrieve the city scoring for the city
     *
     * @param city the city to get the scoring
     * @return the scoring
     */
    private Optional<CityDigitalScoring> getCityScoring(City city) {
        return cityDigitalScoringDAO.getByCityId(city.getCtyId());
    }

    /**
     * Retrieve the city scoring for the city
     *
     * @param city the city to get the scoring
     * @return the scoring
     */
    private CityDigitalScoring calculateCityScoring(City city) {
        //calculate
        //extract data from import table pour tout les indicateurs



        //if missing poverty rate -> special average department
        Department department = departmentDAO.findById(city.getDptId());
        //region
        Region region = regionDAO.findById(department.getRgnId());
        ImpBaseCcFilosofiRegion impBaseCcFilosofiRegion = this.impBaseCcFilosofiRegionDAO.getByCode(region.getRgnCode());

        ImpBaseCcFilosofiDepartement impBaseCcFilosofiDepartement = this.impBaseCcFilosofiDepartementDAO.getByCode(department.getDptCode());

        CityDigitalScoring scoring = consolidatedDataFromCity(city);

        //calculate threshold
        CityDigitalScoring threshold = new CityDigitalScoring(); // TODO complete

        Calculating.updateScoreBaseOfScoring(scoring, threshold);

        cityDigitalScoringDAO.persist(scoring);

        return scoring;
    }

    /**
     * Consolidated data from city extracted data.
     *
     * @param city the city to search
     * @return the Scoring values extracted.
     */
    private CityDigitalScoring consolidatedDataFromCity(City city) {
        CityDigitalScoring scoring = setPopulate(city);
        scoring.setCdsCityId(city.getCtyId());

        setSingle(city, scoring);
        setDiploma(city, scoring);
        setNetwork(city, scoring);
        setMetropolis(city, scoring);
        setFilosofi(city, scoring);

        return scoring;
    }

    private void setFilosofi(City city, CityDigitalScoring scoring) {
        List<ImpBaseCcFilosofi> filosofiList = this.impBaseCcFilosofieDAO.getByCode(city.getCtyCodeArm());
        BigDecimal flfMedianIncome = BigDecimal.ZERO;
        BigDecimal flfPovertyRate = BigDecimal.ZERO;
        int nbRowMedian = 0;
        int nbRowPoverty = 0;

        for (ImpBaseCcFilosofi impBaseCcFilosofi : filosofiList) {
            if (impBaseCcFilosofi.getFlfMedianIncome() != null) {
                flfMedianIncome = flfMedianIncome.add(impBaseCcFilosofi.getFlfMedianIncome());
                nbRowMedian++;
            }
            if (impBaseCcFilosofi.getFlfPovertyRate() != null) {
                flfPovertyRate = flfPovertyRate.add(impBaseCcFilosofi.getFlfPovertyRate());
                nbRowPoverty++;
            }
        }

        // filosofiList should be average data so if nbRow over 1 we will have to divide by it.
        if (nbRowMedian > 1) {
            flfMedianIncome = flfMedianIncome.divide(BigDecimal.valueOf(nbRowMedian), 4, RoundingMode.HALF_UP);
        }
        if (nbRowPoverty > 1) {
            flfPovertyRate = flfPovertyRate.divide(BigDecimal.valueOf(nbRowPoverty), 4, RoundingMode.HALF_UP);
        }


        scoring.setCdsPovertyRate(flfPovertyRate.divide(BIG_DECIMAL_100));
        scoring.setCdsMedianIncome(flfMedianIncome);
    }

    private void setMetropolis(City city, CityDigitalScoring scoring) {
        List<ImpMetropoleSites> mobileList = this.impMetropoleSitesDAO.getByCode(city.getCtyCodeArm());
        BigDecimal mpsCodeAccessibility2G = BigDecimal.ZERO;

        for (ImpMetropoleSites impMetropoleSites : mobileList) {
            if (impMetropoleSites.getMpsCodeAccessibility2G() != null) {
                mpsCodeAccessibility2G = mpsCodeAccessibility2G.add(impMetropoleSites.getMpsCodeAccessibility2G());
            }
        }

        if (mpsCodeAccessibility2G.compareTo(BigDecimal.ONE) > 0) {
            scoring.setCdsMobilityCoverageRate2G(BigDecimal.ONE);
        } else {
            scoring.setCdsMobilityCoverageRate2G(BigDecimal.ZERO);
        }
    }

    private void setNetwork(City city, CityDigitalScoring scoring) {
        List<ImpHdThdDeploiement> hdList = this.impHdThdDeploiementDAO.getByCode(city.getCtyCodeArm());
        BigDecimal htdAvailableNetworks = BigDecimal.ZERO;
        BigDecimal htdBestRate = BigDecimal.ZERO;

        for (ImpHdThdDeploiement impHdThdDeploiement : hdList) {
            if (impHdThdDeploiement.getHtdAvailableNetworks() != null) {
                htdAvailableNetworks = htdAvailableNetworks.add(BigDecimal.valueOf(impHdThdDeploiement.getHtdAvailableNetworks()));
            }
            if (impHdThdDeploiement.getHtdBestRate() != null) {
                htdBestRate = htdBestRate.add(impHdThdDeploiement.getHtdBestRate());
            }
        }
        scoring.setCdsNetworkRateCoverage(htdAvailableNetworks.divide(htdBestRate, 4, RoundingMode.HALF_UP));
    }

    private void setDiploma(City city, CityDigitalScoring scoring) {
        List<ImpBaseIcDiplomesFormation> diplomaList = this.impBaseIcDiplomesFormationDAO.getByCode(city.getCtyCodeArm());
        BigDecimal dlfUnschooledOver15 = BigDecimal.ZERO;
        BigDecimal dlfUnschooledNoDiplomaOver15 = BigDecimal.ZERO;

        for (ImpBaseIcDiplomesFormation impBaseIcDiplomesFormation : diplomaList) {
            if (impBaseIcDiplomesFormation.getDlfUnscholarOver15() != null) {
                dlfUnschooledOver15 = dlfUnschooledOver15.add(BigDecimal.valueOf(impBaseIcDiplomesFormation.getDlfUnscholarOver15()));
            }
            if (impBaseIcDiplomesFormation.getDlfUnscholarNoDiplomaOver15() != null) {
                dlfUnschooledNoDiplomaOver15 = dlfUnschooledNoDiplomaOver15.add(BigDecimal.valueOf(impBaseIcDiplomesFormation.getDlfUnscholarNoDiplomaOver15()));
            }
        }

        scoring.setCdsNoDiplomaOver15(dlfUnschooledOver15.divide(dlfUnschooledNoDiplomaOver15, 4, RoundingMode.HALF_UP));
    }

    private void setSingle(City city, CityDigitalScoring scoring) {
        List<ImpBaseIcCouplesFamillesMenages> coupleList = this.impBaseIcCouplesFamillesMenagesDAO.getByCode(city.getCtyCodeArm());
        BigDecimal cfmSingle = BigDecimal.ZERO;
        BigDecimal cfmSingleParent = BigDecimal.ZERO;

        for (ImpBaseIcCouplesFamillesMenages impBaseIcCouplesFamillesMenages : coupleList) {
            if (impBaseIcCouplesFamillesMenages.getCfmSingle() != null) {
                cfmSingle = cfmSingle.add(BigDecimal.valueOf(impBaseIcCouplesFamillesMenages.getCfmSingle()));
            }
            if (impBaseIcCouplesFamillesMenages.getCfmSingleParent() != null) {
                cfmSingleParent = cfmSingleParent.add(BigDecimal.valueOf(impBaseIcCouplesFamillesMenages.getCfmSingleParent()));
            }
        }

        scoring.setCdsSingleParent(cfmSingleParent);
        scoring.setCdsSingle(cfmSingle);
    }

    private CityDigitalScoring setPopulate(City city) {
        List<ImpBaseIcEvolStructProp> populateList = this.impBaseIcEvolStructPropDAO.getByCode(city.getCtyCodeArm());
        CityDigitalScoring scoring = new CityDigitalScoring();

        BigDecimal espPopAge014 = BigDecimal.ZERO;
        BigDecimal espPopAge1529 = BigDecimal.ZERO;
        BigDecimal espPopAgeOver65 = BigDecimal.ZERO;
        BigDecimal espPopNoJobOver15 = BigDecimal.ZERO;
        int espPopTotalPop = 0;

        for (ImpBaseIcEvolStructProp impBaseIcEvolStructProp : populateList) {
            if (impBaseIcEvolStructProp.getEspPopAge014() != null) {
                espPopAge014 = espPopAge014.add(BigDecimal.valueOf(impBaseIcEvolStructProp.getEspPopAge014()));
            }
            if (impBaseIcEvolStructProp.getEspPopAge1529() != null) {
                espPopAge1529 = espPopAge1529.add(BigDecimal.valueOf(impBaseIcEvolStructProp.getEspPopAge1529()));
            }
            if (impBaseIcEvolStructProp.getEspPopAgeOver65() != null) {
                espPopAgeOver65 = espPopAgeOver65.add(BigDecimal.valueOf(impBaseIcEvolStructProp.getEspPopAgeOver65()));
            }
            if (impBaseIcEvolStructProp.getEspPopNoJobOver15() != null) {
                espPopNoJobOver15 = espPopNoJobOver15.add(BigDecimal.valueOf(impBaseIcEvolStructProp.getEspPopNoJobOver15()));
            }
            if (impBaseIcEvolStructProp.getEspTotalPop() != null) {
                espPopTotalPop = espPopTotalPop + impBaseIcEvolStructProp.getEspTotalPop();
            }
        }

        if (espPopTotalPop > 0) {
            BigDecimal popAge15To64 = BigDecimal.valueOf(espPopTotalPop).subtract(espPopAge014).subtract(espPopAgeOver65);
            scoring.setCdsJobless15To64(espPopNoJobOver15.divide(popAge15To64, 4, RoundingMode.HALF_UP));
        } else {
            scoring.setCdsJobless15To64(BigDecimal.ZERO);
        }

        scoring.setCdsLegalPopulation(espPopTotalPop);
        scoring.setCdsPersonAged15To29(espPopAge1529);
        scoring.setCdsPersonAgedOver65(espPopAgeOver65);
        scoring.setCdsNoDiplomaOver15(espPopNoJobOver15);

        return scoring;
    }

    /**
     * Retrieve the department scoring for the department
     *
     * @param department the department
     * @return the scoring of the department
     */
    private Optional<DepartmentDigitalScoring> getDepartmentScoring(Department department) {
        return departmentDigitalScoringDAO.getByDeptartmentId(department.getDptId());
    }

    /**
     * Retrieve the department scoring for the department
     *
     * @param department the department
     * @return the scoring of the department
     */
    private DepartmentDigitalScoring calculateDepartmentScoring(Department department) {
        //TODO calculate and save
        return null;
    }

    /**
     * Retrieve the region of the city
     *
     * @param department the department of the region to search
     * @return the department of the city
     */
    private Region getRegion(Department department) {
        return this.regionDAO.findById(department.getRgnId());
    }

    /**
     * Retrieve the department of the city
     *
     * @param city the city of the department to search
     * @return the department of the city
     */
    private Department getDepartment(City city) {
        return this.departmentDAO.findById(city.getDptId());
    }

    /**
     * Generate the default value for region
     *
     * @return the region scoring values
     */
    private RegionDigitalScoringModel generateRegionDigitalScoring() {
        // FIXME
        int cdrDepartmentId = 0;
        Integer cdrLegalPopulation = null;
        Integer cdrSingle = null;
        Integer cdrPersonAged15To29 = null;
        Integer cdrNoDiplomaOver15 = null;
        Integer cdrJobless15To64 = null;
        Integer cdrSingleParent = null;
        Integer cdrPersonAgedOver65 = null;
        BigDecimal cdrMedianIncome = null;
        BigDecimal cdrPovertyRate = null;
        BigDecimal cdrPublicService = null;
        BigDecimal cdrPublicServicePerPerson = null;
        BigDecimal cdrMobilityCoverageRate2G = null;
        BigDecimal cdrNetworkRateCoverage = null;
        return new RegionDigitalScoringModel(cdrLegalPopulation, cdrNetworkRateCoverage, cdrMobilityCoverageRate2G, cdrPovertyRate, cdrMedianIncome, cdrSingleParent, cdrSingle, cdrPublicServicePerPerson, cdrPublicService, cdrJobless15To64, cdrPersonAged15To29, cdrPersonAgedOver65, cdrNoDiplomaOver15, cdrDepartmentId, null, null, null, null);
    }
}
