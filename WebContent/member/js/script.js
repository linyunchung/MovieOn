let navbar = document.querySelector(".navbar");
let searchBox = document.querySelector(".search-box .bx-search");
let overlay = document.querySelector(".overlay")

searchBox.addEventListener("click", ()=>{
    navbar.classList.toggle("showInput");
    if(navbar.classList.contains("showInput")){
        searchBox.classList.replace("bx-search", "bx-x");
    }else {
        searchBox.classList.replace("bx-x", "bx-search");
    }
})

//sidebart open close js Code
let menuOpenBtn = document.querySelector(".navbar .bx-menu");
let closeOpenBtn = document.querySelector(".nav-links .bx-x");
let navLinks = document.querySelector(".nav-links");

menuOpenBtn.addEventListener("click", ()=>{
    navLinks.style.left= "0";
    overlay.classList.add("show")
});
closeOpenBtn.addEventListener("click", ()=>{
    navLinks.style.left= "-100%";  
    overlay.classList.remove("show") 
});

let tanArrow = document.querySelector(".tansuo");
tanArrow.addEventListener("click", ()=>{
    navLinks.classList.toggle("show1");
});
let shikeArrow = document.querySelector(".shike");
shikeArrow.addEventListener("click", ()=>{
    navLinks.classList.toggle("show2");
});
let jiaoyouArrow = document.querySelector(".jiaoyou");
jiaoyouArrow.addEventListener("click", ()=>{
    navLinks.classList.toggle("show3");
});
let shangchengArrow = document.querySelector(".shangcheng");
shangchengArrow.addEventListener("click", ()=>{
    navLinks.classList.toggle("show4");
});
let zhongxinArrow = document.querySelector(".zhongxin");
zhongxinArrow.addEventListener("click", ()=>{
    navLinks.classList.toggle("show5");
});
