import html2pdf from 'html2pdf.js';
import { expandAll } from './collapsable';
/**
 * Populate the data to display for the full scoring object
 *
 * @param {*} data the scoring detail result with the data for the city, department and region with all their criteria
 */
const showCard = (data) => {
    if (data != null) {
        document.getElementById("cardResult").style.display = "block";

        if (data.cityDigitalScoring != null) {
            fillCityData(data.cityDigitalScoring);
        }

        if(data.city != null){
            showCityInformation(data.city);
        }

        if (data.departmentDigitalScoring != null) {
            fillDepartmentData(data.departmentDigitalScoring);
        }

        if(data.department != null){
            showDepartmentInformation(data.department);
        }

        if (data.regionDigitalScoring != null) {
            fillRegionData(data.regionDigitalScoring);
        }

        if(data.region != null){
            showRegionInformation(data.region);
        }
    }
};

/**
 * Hide the card and reset all the data displayed
 */
const hideCard = () => {
    document.getElementById("cardResult").style.display = "none";
    document.getElementById("headerScore").innerHTML = "";
    document.getElementById("cityScore").innerHTML = "";
    document.querySelector("#cityData .content").innerHTML = "";
    document.getElementById("departmentScore").innerHTML = "";
    document.querySelector("#departmentData .content").innerHTML = "";
    document.getElementById("regionScore").innerHTML = "";
    document.querySelector("#regionData .content").innerHTML = "";
    document.getElementById("resultCardFirstSection").innerHTML = "";
};

const generatePdf = () => {
    document.body.style.cursor = 'wait';
    // We expand all the hidden sections
    expandAll();

    setTimeout(function(){
        var cardElement = document.getElementById('cardResult');
        html2pdf(cardElement);
        document.body.style.cursor='default';
    }, 1500);
};

/**
 * Display all the data regarding the city
 *
 * @param {*} cityData scoring details of the city
 */
function fillCityData(cityData) {
    var scoring = getScoring(cityData.cdsDigitalInterface, cityData.cdsInformationAccess,
        cityData.cdsDigitalSkill, cityData.cdsAdministrationSkill);

    // Scoring in header
    document.getElementById("headerScore").innerHTML = scoring.toFixed(2) ?? "";

    // Scoring in the detail
    document.getElementById("cityScore").innerHTML = scoring.toFixed(2) ?? "";

    let detailContent = getValueRow(
        "Accès aux interfaces digitales",
        cityData.cdsDigitalInterface,
        ""
    );
    detailContent += getValueRow(
        "Accès à l'information",
        cityData.cdsInformationAccess,
        ""
    );
    detailContent += getValueRow(
        "Capacité d'usage des interfaces numériques",
        cityData.cdsDigitalSkill,
        ""
    );
    detailContent += getValueRow(
        "Compétences administratives",
        cityData.cdsAdministrationSkill,
        ""
    );

    if (cityData.scoring != null) {
        displayScoringInformation(cityData.scoring);
    } else {
        document.getElementById("resultCardFirstSection").innerHTML =
            "Votre score ne nous à pas été communiqué et nous n'avons pas pu l'évaluer.";
    }

    document.querySelector("#cityData .content").innerHTML = detailContent;
}

function displayScoringInformation(scoring) {
    // TODO Improve messages & scoring values
    let message = "";
    if (scoring <= 50) {
        message = "Ce score est unique et c'est ça qui nous plait.";
    } else if (scoring > 50 && scoring < 100) {
        message = "Ce score est très bien et c'est ça qui nous plait.";
    } else {
        message = "Ce score est incroyable et c'est ça qui nous plait.";
    }
    document.getElementById("resultCardFirstSection").innerHTML = message;
}

/**
 * Display all the data regarding the department
 *
 * @param {*} departmentData scoring details of the department
 */
function fillDepartmentData(departmentData) {
    var scoring = getScoring(cityData.cddDigitalInterface, cityData.cddInformationAccess,
        cityData.cddDigitalSkill, cityData.cddAdministrationSkill);

    // Scoring in the detail
    document.getElementById("departmentScore").innerHTML =
        scoring.toFixed(2) ?? "";

    let detailContent = getValueRow(
        "Accès aux interfaces digitales",
        departmentData.cddDigitalInterface,
        ""
    );
    detailContent += getValueRow(
        "Accès à l'information",
        departmentData.cddInformationAccess,
        ""
    );
    detailContent += getValueRow(
        "Capacité d'usage des interfaces numériques",
        departmentData.cddDigitalSkill,
        ""
    );
    detailContent += getValueRow(
        "Compétences administratives",
        departmentData.cddAdministrationSkill,
        ""
    );

    document.querySelector(
        "#departmentData .content"
    ).innerHTML = detailContent;
}

/**
 * Display all the data regarding the region
 *
 * @param {*} regionData scoring details of the region
 */
function fillRegionData(regionData) {
    var scoring = getScoring(cityData.cdrDigitalInterface, cityData.cdrInformationAccess,
        cityData.cdrDigitalSkill, cityData.cdrAdministrationSkill);

    // Scoring in the detail
    document.getElementById("regionScore").innerHTML = scoring ?? "";

    let detailContent = getValueRow(
        "Accès aux interfaces digitales",
        regionData.cdrDigitalInterface,
        null
    );
    detailContent += getValueRow(
        "Accès à l'information",
        regionData.cdrInformationAccess,
        null
    );
    detailContent += getValueRow(
        "Capacité d'usage des interfaces numériques",
        regionData.cdrDigitalSkill,
        null
    );
    detailContent += getValueRow(
        "Compétences administratives",
        regionData.cdrAdministrationSkill,
        null
    );

    document.querySelector("#regionData .content").innerHTML = detailContent;
}

/**
 * Generate HTML for the current data and label
 * @param {*} label scoring property label
 * @param {*} value scoring value
 * @param {*} suffix suffix added to the suffix
 */
function getValueRow(label, value, suffix) {
    var valueOutput = value.toFixed(2) ?? "";
    return `<div class="content-property-name">${label}</div><div class="content-property-value">${valueOutput} ${suffix ?? ""}</div>`;
}

/**
 * Display the information about the selected city (CP & name)
 *
 * @param {*} cityInfo
 */
function showCityInformation(cityInfo){
    document.getElementById("cityDetail").innerHTML = `${cityInfo.ctyName} - ${cityInfo.ctyPostalCode}`;
}

/**
 * Display the information about the department city (code & name)
 *
 * @param {*} dptInfo
 */
function showDepartmentInformation(dptInfo){
    document.getElementById("departmentDetail").innerHTML = `${dptInfo.dptCode} - ${dptInfo.dptName}`;
}

/**
 * Display the information about the region (name)
 *
 * @param {*} regionInfo
 */
function showRegionInformation(regionInfo){
    document.getElementById("regionDetail").innerHTML = `${regionInfo.rgnName}`;
}

function getScoring(val1, val2, val3, val4){
    return (val1 + val2 + val3 + val4);
}

export { showCard, hideCard, generatePdf };
