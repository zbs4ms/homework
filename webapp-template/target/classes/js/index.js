"use strict";

var loginBtn = document.getElementsByClassName("login-btn");
var modalMask = document.getElementById("modal-mask");
var form = document.getElementsByClassName("form");
var formLogin = document.getElementsByClassName("form-login")[0];
var formRegistry = document.getElementsByClassName("form-registry")[0];
var btnActive = document.getElementsByClassName("login-input-active");
var btnNotActive = document.getElementsByClassName("login-input-not-active");

for (var i = 0; i < loginBtn.length; i++) {
  loginBtn[i].onclick = function () {
    modalMask.style.width = window.innerWidth + "px";
    modalMask.style.height = window.innerHeight + "px";
    modalMask.style.top = document.body.scrollTop + "px";
    modalMask.style.left = document.body.scrollLeft + "px";
    modalMask.style.display = "block";
    formLogin.style.display = "block";
    document.body.style.overflow = "hidden";
  }
}

for (i = 0; i < btnActive.length; i++) {
  btnNotActive[i].onclick = function () {
    if (window.getComputedStyle(formLogin, null).display == "block") {
      formLogin.style.display = "none";
      formRegistry.style.display = "block";
    } else if (window.getComputedStyle(formRegistry, null).display == "block") {
      formLogin.style.display = "block";
      formRegistry.style.display = "none";
    }
  }
}

modalMask.onclick = function () {
  this.style.display = "none";
  for (i = 0; i < form.length; i++) {
    form[i].style.display = "none";
  }
  document.body.style.overflow = "auto";
};

