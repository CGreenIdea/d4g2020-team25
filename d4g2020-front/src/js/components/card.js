function showCard(data) {
    if (data != null) {
        document.getElementById("cardResult").style("display: block");

        if (data.city != null) {
            fillCityData(data.city);
        }

        if (data.department != null) {
            fillDepartmentData(data.department);
        }

        if (data.region != null) {
            fillRegionData(data.region);
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
    // Scoring in the detail
    document.getElementById("departmentScore").innerHTML(departmentData.scoring);
    let detailContent = "";
    document.querySelector("#departmentData .content").innerHTML(detailContent);
}

function fillRegionData(regionData) {
    // Scoring in the detail
    document.getElementById("regionScore").innerHTML(regionData.scoring);
    let detailContent = "";
    document.querySelector("#regionData .content").innerHTML(detailContent);
}

function getValueRow(label, value, suffix) {
    return `<div class="content-property-name">${label}</div><div class="content-property-value">${value} ${suffix}</div>`;
}
