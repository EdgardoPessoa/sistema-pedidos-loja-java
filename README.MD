Este programa em Java foi desenvolvido para simular um sistema de pedidos de uma loja, onde o usuário pode inserir os dados do cliente, os detalhes do pedido e os itens do pedido. Ao final, o programa exibe um resumo do pedido com as informações inseridas.

### Funcionalidades:
- O programa solicita ao usuário que insira os dados do cliente, incluindo nome, email e data de nascimento.
- Em seguida, o usuário é solicitado a inserir os detalhes do pedido, como status e quantidade de itens.
- Para cada item do pedido, o usuário fornece o nome do produto, o preço e a quantidade desejada.
- Após a inserção de todos os dados, o programa exibe um resumo do pedido, incluindo o momento do pedido, status, detalhes do cliente e itens do pedido.

### Exemplo de Uso:
```
Enter cliente data:
Name: Alex Green
Email: alex@gmail.com
Birth date (DD/MM/YYYY): 15/03/1985
Enter order data:
Status: PROCESSING
How many items to this order? 2
Enter #1 item data:
Product name: TV
Product price: 1000.00
Quantity: 1
Enter #2 item data:
Product name: Mouse
Product price: 40.00
Quantity: 2
ORDER SUMMARY:
Order moment: 20/04/2018 11:25:09
Order status: PROCESSING
Client: Alex Green (15/03/1985) - alex@gmail.com
Order items:
TV, $1000.00, Quantity: 1, Subtotal: $1000.00
Mouse, $40.00, Quantity: 2, Subtotal: $80.00
```

Este programa oferece uma maneira simples de gerenciar pedidos de clientes e exibir um resumo claro e detalhado para referência.