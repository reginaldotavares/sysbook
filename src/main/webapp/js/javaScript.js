// JavaScript Document
$(function() {
    $(".slides").responsiveSlides({
        manualControls: '.slides',
        nav: true,
		pager: false,
		pause: true,
        speed: 500,
        namespace: "callbacks",
        before: function () {
          $('.events').append("<li>before event fired.</li>");
        },
        after: function () {
          $('.events').append("<li>after event fired.</li>");
        }
		
      });
  });
  
  function atualizafoto(){
      var fotoDigitada = document.forms["formCliente"]["clifoto"].value;
      document.forms["formCliente"]["clifoto"].src =   fotoDigitada;
  }
  window.onload = function(){
      document.forms["formCliente"]["clifoto"].oninput = atualizafoto;
  };