function showCard() {
    fillCityData();
    fillDepartmentData();
    fillRegionData();
}

function fillCityData() {}

function fillDepartmentData() {}

function fillRegionData() {}

function getValueRow(label, value, suffix) {
    return `<div class="content-property-name">${label}</div><div class="content-property-value">${value} ${suffix}</div>`;
}
