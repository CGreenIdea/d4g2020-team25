package com.cgi.d4g.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/*
 * class to manage the business of scoring.
 */

import com.cgi.d4g.business.model.RegionDigitalScoringModel;
import com.cgi.d4g.business.model.ScoringResultModel;
import com.cgi.d4g.dao.CityDigitalScoringDAO;
import com.cgi.d4g.dao.DepartmentDAO;
import com.cgi.d4g.dao.DepartmentDigitalScoringDAO;
import com.cgi.d4g.dao.ImpBaseCcFilosofiDepartementDAO;
import com.cgi.d4g.dao.ImpBaseCcFilosofiRegionDAO;
import com.cgi.d4g.dao.ImpBaseCcFilosofieDAO;
import com.cgi.d4g.dao.ImpBaseIcCouplesFamillesMenagesDAO;
import com.cgi.d4g.dao.ImpBaseIcDiplomesFormationDAO;
import com.cgi.d4g.dao.ImpBaseIcEvolStructPropDAO;
import com.cgi.d4g.dao.ImpHdThdDeploiementDAO;
import com.cgi.d4g.dao.ImpMetropoleSitesDAO;
import com.cgi.d4g.dao.RegionDAO;
import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.CityDigitalScoring;
import com.cgi.d4g.entity.Department;
import com.cgi.d4g.entity.DepartmentDigitalScoring;
import com.cgi.d4g.entity.ImpBaseCcFilosofi;
import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseCcFilosofiRegion;
import com.cgi.d4g.entity.ImpBaseIcCouplesFamillesMenages;
import com.cgi.d4g.entity.ImpBaseIcDiplomesFormation;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;
import com.cgi.d4g.entity.ImpHdThdDeploiement;
import com.cgi.d4g.entity.ImpMetropoleSites;
import com.cgi.d4g.entity.Region;

@ApplicationScoped
public class Scoring {

    /**
     * constant used in the calculation
     */
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
        this.impBaseIcDiplomesFormationDAO = impBaseIcDiplomesFormationDAO;
        this.impHdThdDeploiementDAO = impHdThdDeploiementDAO;
        this.impMetropoleSitesDAO = impMetropoleSitesDAO;
        this.impBaseCcFilosofiRegionDAO = impBaseCcFilosofiRegionDAO;
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

        return new ScoringResultModel(city, cityDigitalScoring.orElse(calculateCityScoring(city)).getCityDigitalScoringModel(), department, departmentDigitalScoring.orElse(calculateDepartmentScoring(department)).getDepartmentDigitalScoringModel(), region, regionDigitalScoring);
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

        //if missing poverty rate -> special average department
        Department department = departmentDAO.findById(city.getDptId());
        //region
        Region region = regionDAO.findById(department.getRgnId());
        ImpBaseCcFilosofiRegion impBaseCcFilosofiRegion = this.impBaseCcFilosofiRegionDAO.getByCode(region.getRgnCode());
        ImpBaseCcFilosofiDepartement impBaseCcFilosofiDepartement = this.impBaseCcFilosofiDepartementDAO.getByCode(department.getDptCode());

        //extract data from import table pour tout les indicateurs
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
        ccFilosofieToScoring(scoring, flfMedianIncome, flfPovertyRate);
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
        hdThdDeploiementDAO(scoring, htdAvailableNetworks, htdBestRate);
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

        icDiplomesFormationToScoring(scoring, dlfUnschooledOver15, dlfUnschooledNoDiplomaOver15);
    }


    private void setSingle(City city, CityDigitalScoring scoring) {
        List<ImpBaseIcCouplesFamillesMenages> coupleList = this.impBaseIcCouplesFamillesMenagesDAO.getByCode(city.getCtyCodeArm());
        BigDecimal cfmSingle = BigDecimal.ZERO;
        BigDecimal cfmSingleParent = BigDecimal.ZERO;
        BigDecimal cfmHousehold = BigDecimal.ZERO;

        for (ImpBaseIcCouplesFamillesMenages impBaseIcCouplesFamillesMenages : coupleList) {
            if (impBaseIcCouplesFamillesMenages.getCfmSingle() != null) {
                cfmSingle = cfmSingle.add(BigDecimal.valueOf(impBaseIcCouplesFamillesMenages.getCfmSingle()));
            }
            if (impBaseIcCouplesFamillesMenages.getCfmSingleParent() != null) {
                cfmSingleParent = cfmSingleParent.add(BigDecimal.valueOf(impBaseIcCouplesFamillesMenages.getCfmSingleParent()));
            }
            if (impBaseIcCouplesFamillesMenages.getCfmHousehold() != null) {
                cfmHousehold = cfmHousehold.add(BigDecimal.valueOf(impBaseIcCouplesFamillesMenages.getCfmHousehold()));
            }
        }
        icCouplesFamiliesMenageToScoring(scoring, cfmSingle, cfmSingleParent, cfmHousehold);
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

        icEvolStructPropToScoring(scoring, espPopAge1529, espPopAgeOver65, espPopNoJobOver15, espPopTotalPop);

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
        return new RegionDigitalScoringModel( BigDecimal.valueOf(1), BigDecimal.valueOf(2), BigDecimal.valueOf(3), BigDecimal.valueOf(4));
    }

    private void icCouplesFamiliesMenageToScoring(CityDigitalScoring scoring, BigDecimal cfmSingle,
                                                  BigDecimal cfmSingleParent, BigDecimal cfmHousehold) {
        scoring.setCdsSingleParent(cfmSingleParent.divide(cfmHousehold, 4, RoundingMode.HALF_UP));
        scoring.setCdsSingle(cfmSingle.divide(cfmHousehold, 4, RoundingMode.HALF_UP));
    }

    private void icEvolStructPropToScoring(CityDigitalScoring scoring, BigDecimal espPopAge1529, BigDecimal espPopAgeOver65,
                                           BigDecimal espPopNoJobOver15, int espPopTotalPop) {
        scoring.setCdsLegalPopulation(espPopTotalPop);
        scoring.setCdsPersonAged15To29(espPopAge1529.divide(BigDecimal.valueOf(espPopTotalPop), 4, RoundingMode.HALF_UP));
        scoring.setCdsPersonAgedOver65(espPopAgeOver65.divide(BigDecimal.valueOf(espPopTotalPop), 4, RoundingMode.HALF_UP));
        scoring.setCdsJobless15To64(espPopNoJobOver15.divide(BigDecimal.valueOf(espPopTotalPop), 4, RoundingMode.HALF_UP));
    }

    private void ccFilosofieToScoring(CityDigitalScoring scoring, BigDecimal flfMedianIncome,
                                      BigDecimal flfPovertyRate) {
        scoring.setCdsPovertyRate(flfPovertyRate.divide(BIG_DECIMAL_100));
        scoring.setCdsMedianIncome(flfMedianIncome);
    }

    private void hdThdDeploiementDAO(CityDigitalScoring scoring, BigDecimal htdAvailableNetworks,
                                     BigDecimal htdBestRate) {
        scoring.setCdsNetworkRateCoverage(htdAvailableNetworks.divide(htdBestRate, 4, RoundingMode.HALF_UP));
    }

    private void icDiplomesFormationToScoring(CityDigitalScoring scoring, BigDecimal dlfUnschooledOver15,
                                              BigDecimal dlfUnschooledNoDiplomaOver15) {
        scoring.setCdsNoDiplomaOver15(dlfUnschooledOver15.divide(dlfUnschooledNoDiplomaOver15, 4, RoundingMode.HALF_UP));
    }
}
