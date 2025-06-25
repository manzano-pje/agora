const tableBody = document.querySelector('#associadosTable tbody');

async function fetchAssociados() {
  try {
    // Simulando API (substitua pela URL real)
    const response = await fetch('/api/associados');
    if (!response.ok) throw new Error('Erro na requisição da API');

    const associados = await response.json();

    preencherTabela(associados);
  } catch (error) {
    alert('Erro ao carregar associados: ' + error.message);
  }
}

function preencherTabela(associados) {
  tableBody.innerHTML = '';

  associados.forEach(assoc => {
    const tr = document.createElement('tr');
    tr.classList.add('cursor-pointer', 'hover:bg-gray-100');
    tr.innerHTML = `
      <td class="p-4 border-b border-gray-300">${assoc.codigo}</td>
      <td class="p-4 border-b border-gray-300">${assoc.name}</td>
      <td class="p-4 border-b border-gray-300">${formatCPF(assoc.cpf)}</td>
      <td class="p-4 border-b border-gray-300">${assoc.phone}</td>
    `;

    tr.addEventListener('click', () => {
      window.location.href = `cadastro-associado.html?codigo=${encodeURIComponent(assoc.codigo)}`;
    });

    tableBody.appendChild(tr);
  });
}

fetchAssociados();
