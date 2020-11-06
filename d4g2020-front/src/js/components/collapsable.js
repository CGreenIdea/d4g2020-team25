const toggleCollapsible = (toggle) => {
    toggle.closest(".collapsible").classList.toggle("expanded");
};

const initCollapsables = () => {
    document.querySelectorAll(".collapsible .toggle").forEach((toggle) => {
        toggle.addEventListener("click", (event) =>
            toggleCollapsible(event.target)
        );
    });
};

const expandAll = () => {
    document
        .querySelectorAll(".collapsible:not(.expanded)")
        .forEach((element) => toggleCollapsible(element));
};

export { initCollapsables, expandAll };
