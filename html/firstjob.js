var btnclicked = 0;

function Clicker() {
    btnclicked++;
    document.getElementById("clickCount").textContent = btnclicked;
}

document.querySelector(".btn").addEventListener("click", Clicker);