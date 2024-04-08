function login() {
    document.getElementById('verificar').addEventListener('click', function () {
        const email = document.getElementById('email_login').value;
        const password = document.getElementById('password_login').value;

        const data = {
            email: email,
            password: password
        };

        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Erro ao fazer login');
                }
                alert('Login bem-sucedido');
                // Redirecionar para a página desejada após o login
                window.location.href = 'home.html';
            })
            .catch(error => {
                console.error('Erro:', error);
                // Lidar com o erro de login aqui
            });
    });
}