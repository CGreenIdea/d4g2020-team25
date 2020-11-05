function showCard(data) {
    if (data != null) {
        if (data.city != null) {
            fillCityData();
        }

        if (data.department != null) {
            fillDepartmentData();
        }

        if (data.region != null) {
            fillRegionData();
        }
    }
}

function fillCityData(cityData) {
    // Scoring in header
    document.getElementById("headerScore").innerHTML(cityData.scoring);

    // Scoring in the detail
    document.getElementById("cityScore").innerHTML(cityData.scoring);

    let detailContent = ""; //getValueRow(cityData.criteriaLabel, cityData.criteriaValue, null);

    //detailContent += getValueRow(cityData.criteriaLabel, cityData.criteriaValue, null);

    document.querySelector("#cityData .content").innerHTML(detailContent);
}

function fillDepartmentData(departmentData) {

}

function fillRegionData(regionData) {

}

function getValueRow(label, value, suffix) {
    return `<div class="content-property-name">${label}</div><div class="content-property-value">${value} ${suffix}</div>`;
}
