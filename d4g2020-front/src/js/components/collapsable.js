const toggleCollapsible = toggle => {
    toggle.closest('.collapsible').classList.toggle('expanded');
};

const initCollapsables = () => {
    document.querySelectorAll('.collapsible .toggle')
        .forEach(toggle => {
            toggle.addEventListener(
                'click',
                event => toggleCollapsible(event.target)
            );
        });
};

export { initCollapsables };
