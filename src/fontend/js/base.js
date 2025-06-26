// base.js: menu sanfona e funções auxiliares

document.querySelectorAll('.accordion-btn').forEach(btn => {
  btn.addEventListener('click', () => {
    const submenu = btn.nextElementSibling;

    const isOpen = submenu.style.maxHeight && submenu.style.maxHeight !== '0px';

    if (isOpen) {
      submenu.style.maxHeight = '0';
      btn.querySelector('svg').classList.remove('rotate-180');
    } else {
      submenu.style.maxHeight = submenu.scrollHeight + 'px';
      btn.querySelector('svg').classList.add('rotate-180');
    }
  });
});

// Formatação de CPF simples
function formatCPF(cpf) {
  return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
}

// Pega query param da URL
function getQueryParam(name) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(name);
}
