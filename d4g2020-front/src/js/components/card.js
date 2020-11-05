/**
 * Populate the data to display for the full scoring object
 *
 * @param {*} data the scoring detail result with the data for the city, department and region with all their criteria
 */
const showCard = (data) => {
    if (data != null) {
        document.getElementById("cardResult").style("display: block");

        if (data.cityDigitalScoring != null) {
            fillCityData(data.cityDigitalScoring);
        }

        if (data.departmentDigitalScoring != null) {
            fillDepartmentData(data.departmentDigitalScoring);
        }

        if (data.regionDigitalScoring != null) {
            fillRegionData(data.regionDigitalScoring);
        }
    }
};

/**
 * Hide the card and reset all the data displayed
 */
const hideCard = () => {
    document.getElementById("cardResult").style("display: none");
    document.getElementById("headerScore").innerHTML("");
    document.getElementById("cityScore").innerHTML("");
    document.querySelector("#cityData .content").innerHTML("");
    document.getElementById("departmentScore").innerHTML("");
    document.querySelector("#departmentData .content").innerHTML("");
    document.getElementById("regionScore").innerHTML("");
    document.querySelector("#regionData .content").innerHTML("");
};

/**
 * Display all the data regarding the city
 *
 * @param {*} cityData scoring details of the city
 */
function fillCityData(cityData) {
    // Scoring in header
    document.getElementById("headerScore").innerHTML(cityData.scoring);

    // Scoring in the detail
    document.getElementById("cityScore").innerHTML(cityData.scoring);

    let detailContent = getValueRow(
        "Accès aux interfaces digitales",
        cityData.cdsDigitalInterface,
        null
    );
    detailContent += getValueRow(
        "Accès à l'information",
        cityData.cdsInformationAccess,
        null
    );
    detailContent += getValueRow(
        "Capacité d'usage des interfaces numériques",
        cityData.cdsDigitalSkill,
        null
    );
    detailContent += getValueRow(
        "Compétences administratives",
        cityData.cdsAdministrationSkill,
        null
    );

    document.querySelector("#cityData .content").innerHTML(detailContent);
}

/**
 * Display all the data regarding the department
 *
 * @param {*} departmentData scoring details of the department
 */
function fillDepartmentData(departmentData) {
    // Scoring in the detail
    document
        .getElementById("departmentScore")
        .innerHTML(departmentData.scoring);
    l;
    let detailContent = getValueRow(
        "Accès aux interfaces digitales",
        departmentData.cddDigitalInterface,
        null
    );
    detailContent += getValueRow(
        "Accès à l'information",
        departmentData.cddInformationAccess,
        null
    );
    detailContent += getValueRow(
        "Capacité d'usage des interfaces numériques",
        departmentData.cddDigitalSkill,
        null
    );
    detailContent += getValueRow(
        "Compétences administratives",
        departmentData.cddAdministrationSkill,
        null
    );

    document.querySelector("#departmentData .content").innerHTML(detailContent);
}

/**
 * Display all the data regarding the region
 *
 * @param {*} regionData scoring details of the region
 */
function fillRegionData(regionData) {
    // Scoring in the detail
    document.getElementById("regionScore").innerHTML(regionData.scoring);

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

    document.querySelector("#regionData .content").innerHTML(detailContent);
}

/**
 * Generate HTML for the current data and label
 * @param {*} label scoring property label
 * @param {*} value scoring value
 * @param {*} suffix suffix added to the suffix
 */
function getValueRow(label, value, suffix) {
    return `<div class="content-property-name">${label}</div><div class="content-property-value">${value} ${suffix}</div>`;
}

export { showCard, hideCard };
