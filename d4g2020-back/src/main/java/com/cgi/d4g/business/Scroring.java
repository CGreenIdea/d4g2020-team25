package com.cgi.d4g.business;
/*
 * class to manage the business of scoring.
 */
import com.cgi.d4g.business.model.RegionDigitalScoringModel;
import com.cgi.d4g.business.model.ScoringResultModel;
import com.cgi.d4g.dao.*;
import com.cgi.d4g.entity.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Scroring {

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
     * Constructor
     * @param regionDAO the region DAO
     * @param departmentDAO the department DAO
     */
    public Scroring(RegionDAO regionDAO, DepartmentDAO departmentDAO,
                    CityDigitalScoringDAO cityDigitalScoringDAO, DepartmentDigitalScoringDAO departmentDigitalScoringDAO,
                    ImpBaseCcFilosofiDepartementDAO impBaseCcFilosofiDepartementDAO) {
        this.regionDAO = regionDAO;
        this.departmentDAO = departmentDAO;
        this.cityDigitalScoringDAO = cityDigitalScoringDAO;
        this.departmentDigitalScoringDAO = departmentDigitalScoringDAO;
        this.impBaseCcFilosofiDepartementDAO = impBaseCcFilosofiDepartementDAO;
    }

    /**
     * Compute the scoring for a city
     * @param city the city where the scoring is requested.
     */
    public ScoringResultModel getOrRetriveScorring(City city) {
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
     * @param city the city to get the scoring
     * @return the scoring
     */
    private Optional<CityDigitalScoring> getCityScoring(City city) {
        return cityDigitalScoringDAO.getByCityId(city.getCtyId());
    }

    /**
     * Retrieve the city scoring for the city
     * @param city the city to get the scoring
     * @return the scoring
     */
    private CityDigitalScoring calculateCityScoring(City city) {
        //TODO calculate and save

        //calculate
        //extract data from import table pour tout les indicateurs

        //if missing poverty rate -> special average department
        Department department = departmentDAO.findById(city.getDptId());
        ImpBaseCcFilosofiDepartement impBaseCcFilosofiDepartement = impBaseCcFilosofiDepartementDAO.getByCode(department.getDptCode());

        List<ImpBaseIcEvolStructProp> populateList = new ArrayList<>();
        List<ImpBaseIcCouplesFamillesMenages> coupleList = new ArrayList<>();
        List<ImpBaseIcDiplomesFormation> diplomaList = new ArrayList<>();
        List<ImpHdThdDeploiement> hdList = new ArrayList<>();
        List<ImpMetropoleSites> mobileList = new ArrayList<>();
        List<ImpBaseCcFilosofi> filosofiList = new ArrayList<>();

        CityDigitalScoring scoring = new CityDigitalScoring(); // TODO complete

        //par taux
        //calculate or get threshold
        //calculate coeff
        //calculate point
        //calculate score

        //groupe par indicateur
        //calculate score base

        //save data
        return null;
    }

    /**
     * Retrieve the department scoring for the department
     * @param department the department
     * @return the scoring of the department
     */
    private Optional<DepartmentDigitalScoring> getDepartmentScoring(Department department) {
        return departmentDigitalScoringDAO.getByDeptartmentId(department.getDptId());
    }

    /**
     * Retrieve the department scoring for the department
     * @param department the department
     * @return the scoring of the department
     */
    private DepartmentDigitalScoring calculateDepartmentScoring(Department department) {
        //TODO calculate and save
        return null;
    }

    /**
     * Retrieve the region of the city
     * @param department the department of the region to search
     * @return the department of the city
     */
    private Region getRegion(Department department) {
        return this.regionDAO.findById(department.getRgnId());
    }

    /**
     * Retrieve the department of the city
     * @param city the city of the department to search
     * @return the department of the city
     */
    private Department getDepartment(City city) {
        return this.departmentDAO.findById(city.getDptId());
    }

    /**
     * Generate the default value for region
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
