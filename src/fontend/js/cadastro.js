// script.js

document.getElementById('associateForm').addEventListener('submit', function(event) {
  event.preventDefault();

  // Obter os valores dos campos do formulário
  const name = document.getElementById('name').value;
  const rg = document.getElementById('rg').value;
  const cpf = document.getElementById('cpf').value;
  const dateOfBirth = document.getElementById('dateOfBirth').value;
  const phone = document.getElementById('phone').value;
  const email = document.getElementById('email').value;
  const address = document.getElementById('address').value;
  const number = document.getElementById('number').value;
  const complement = document.getElementById('complement').value;
  const cep = document.getElementById('cep').value;
  const city = document.getElementById('city').value;
  const state = document.getElementById('state').value;

  // Criar o objeto com os dados do associado
  const associateData = {
    name,
    rg,
    cpf,
    dateOfBirth,
    phone,
    email,
    address,
    number,
    complement,
    cep,
    city,
    state
  };

  
  // Enviar os dados para o endpoint da API
  fetch('http://localhost:8080/api/v1/associate', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(associateData)
  })
  .then(async response => {
    const texto = await response.text();

    if (response.ok) {
      alert(texto);
      // Limpar os campos do formulário
      document.getElementById('name').value = '';
      document.getElementById('rg').value = '';
      document.getElementById('cpf').value = '';
      document.getElementById('dateOfBirth').value = '';
      document.getElementById('phone').value = '';
      document.getElementById('email').value = '';
      document.getElementById('address').value = '';
      document.getElementById('number').value = '';
      document.getElementById('complement').value = '';
      document.getElementById('cep').value = '';
      document.getElementById('city').value = '';
      document.getElementById('state').value = '';
    } else {
      
      alert('Erro: ' + texto);

    }
  })
  .catch(error => {
    console.error('Erro na requisição: ', error);
    alert('Erro inesperado: ' + error);
  });
});