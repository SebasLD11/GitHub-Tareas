document.addEventListener('DOMContentLoaded', () => {
    let currentSlide = 0;
     const slides = document.querySelectorAll('.slide');
    const totalSlides = slides.length;

   if (totalSlides > 0) {
      function showSlide(index) {
       const slider = document.querySelector('.slider');
        if (slider) {
         slider.style.transform = translateX(-${index * 100}%);
      }
     }

     function nextSlide() {
       currentSlide = (currentSlide + 1) % totalSlides;
      showSlide(currentSlide);
    }

      showSlide(currentSlide);
     setInterval(nextSlide, 3000); // Moves to the next slide every 3 seconds
    }

   const navbar = document.querySelector('.navbar');
    const navLinks = document.querySelector('.nav-links');
    const authButtons = document.querySelector('.auth-buttons');

    if (navbar && navLinks && authButtons) {
     window.addEventListener('scroll', () => {
         if (window.scrollY > 50) {
         navLinks.classList.add('hidden');
        authButtons.classList.add('hidden');
       navbar.classList.add('shrink');
       } else {
          navLinks.classList.remove('hidden');
        authButtons.classList.remove('hidden');
          navbar.classList.remove('shrink');
        }
      });
    }

    // Añadir lógica para la línea amarilla
    const yellowLine = document.querySelector('.yellow-line');
  if (yellowLine) {
     setInterval(() => {
      yellowLine.style.transform = 'translateX(0)';
       setTimeout(() => {
       yellowLine.style.transform = 'translateX(-100%)';
  }, 500); // This matches the CSS transition duration
    }, 5000); // 5 seconds interval
   }
   });