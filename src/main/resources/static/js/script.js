console.log("Script loaded");

let currentTheme = getTheme();

//initial
document.addEventListener("DOMContentLoaded", () => {
  changeTheme();
});

//TODO:
function changeTheme() {
  changePageTheme(currentTheme, currentTheme);

  //set the listener  to change theme button
  const changeThemeButton = document.querySelector("#theme_change_button");

  //   changeThemeButton.querySelector("span").textContent =
  //     currentTheme == "light" ? "Dark" : "Light";

  changeThemeButton.addEventListener("click", (event) => {
    let oldTheme = currentTheme;
    console.log("change theme button clicked");

    if (currentTheme == "dark") {
      // theme to light
      currentTheme = "light";
    } else {
      // theme to dark
      currentTheme = "dark";
    }
    changePageTheme(currentTheme, oldTheme);
  });
}

//set theme to localStorage
function setTheme(theme) {
  localStorage.setItem("theme", theme);
}

//get theme to localStorage
function getTheme() {
  let theme = localStorage.getItem("theme");
  console.log("inside get theme method: " + theme);
  return theme ? theme : "light";
}

// change current page theme
function changePageTheme(theme, oldTheme) {
  // update current theme into local Storage
  setTheme(currentTheme);
  // remove the current theme
  document.querySelector("html").classList.remove(oldTheme);
  // set the current theme
  document.querySelector("html").classList.add(theme);
  // change the text of button
  document
    .querySelector("#theme_change_button")
    .querySelector("span").textContent = theme == "light" ? "Dark" : "Light";
}
