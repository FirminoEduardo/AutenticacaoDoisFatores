/*function criarConta() {
    const nome = document.getElementById("nome_criarconta");
    const email = document.getElementById("email_criarconta");
    const senha = document.getElementById("senha_criarconta");

    const data = {
        nome: nome,
        email: email,
        senha: senha
    };

    fetch('http://localhost:9013', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then(response =>{
        if(!response.ok) {
            throw new Error('Erro ao criar conta');
        }
        return response.json();
    }).then(data => {
        alert('Conta criada com sucesso.');
    }).catch((error) => {
        console.log('Erro: ', error);
        alert('Erro ao criar conta');
    })

}*/