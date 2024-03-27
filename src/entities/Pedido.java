package entities;

import enums.statusPedido;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date momento;
    private statusPedido status;


    private Cliente cliente;
    private List<itemPedido> pedidos = new ArrayList<>();

    public Pedido() {
        
    }

    public Pedido(Date momento, statusPedido status, Cliente cliente) {
        this.momento = momento;
        this.status = status;
        this.cliente = cliente;
    }

    public Date getMomento() {
        return momento;
    }

    public void setMomento(Date momento) {
        this.momento = momento;
    }

    public statusPedido getStatus() {
        return status;
    }

    public void setStatus(statusPedido status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<itemPedido> getPedidos() {
        return pedidos;
    }

    public void adicionarItem(itemPedido pedido) {
        pedidos.add(pedido);
    }

    public void removerItem(itemPedido pedido) {
        pedidos.remove(pedido);
    }
    
    public double total() {
        double soma = 0;
        for (itemPedido item : pedidos) {
            soma += item.subTotal();
        }
        return soma;
    }

    @Override
    public String toString() {
        StringBuilder sbb = new StringBuilder();
        sbb.append("Momento pedido: ");
        sbb.append(sdf.format(momento) + "\n");
        sbb.append("Status pedido: ");
        sbb.append(status + "\n");
        sbb.append("Cliente: ");
        sbb.append(cliente + "\n");
        sbb.append("Itens do pedido:\n");
        for (itemPedido item : pedidos) {
            sbb.append(item + "\n");
        }
        sbb.append("Preço total: $");
        sbb.append(String.format("%.2f", total()));
        return sbb.toString();
    }
}
