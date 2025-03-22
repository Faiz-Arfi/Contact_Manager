console.log('Script Loaded');

// Initialize theme system
document.addEventListener('DOMContentLoaded', () => {
    initThemeSystem();
});// This makes sure that the script is loaded after the DOM is fully loaded

function initThemeSystem() {
    const htmlElement = document.querySelector('html');
    let currentTheme = getTheme();

    // Initial theme application
    applyTheme(currentTheme, htmlElement);

    // Add event listener to toggle theme
    const themeButton = document.querySelector('#theme_change_button');
    if(themeButton){
        themeButton.addEventListener('click', function(){
            currentTheme = currentTheme === 'light'
? 'dark': 'light';
            applyTheme(currentTheme, htmlElement);
        });
    }else{
        console.warn('Theme change button not found');
    }
}

function getTheme() {
    try {
        let theme = localStorage.getItem('theme');
        return theme ? theme : 'light'; // Default theme is light
    } catch (error) {
        console.error('Error getting theme from local storage', error);
        return 'light'; // Default theme is light
    }
}

function applyTheme(theme, element) {
    element.classList.remove('light', 'dark');
    element.classList.add(theme);
    document.querySelector('#theme_text').innerText = theme === 'light' ? 'Dark': 'Light';
    setTheme(theme);
}

function setTheme(theme) {
    try {
        localStorage.setItem('theme', theme);
    } catch (error) {
        console.error('Could not save theme preference', error);
    }
}