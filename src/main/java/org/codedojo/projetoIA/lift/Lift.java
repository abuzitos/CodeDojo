package org.codedojo.projetoIA.lift;

import java.util.PriorityQueue;

/*
 * História de Usuário
 * Como um usuário de um prédio com vários andares,
 * Eu quero usar um elevador para me mover entre os andares,
 * Para que eu possa chegar ao meu destino de forma rápida e conveniente.
 *
 * Critérios de Aceitação
 * Estado Inicial do Elevador
 *
 * Dado que o elevador foi inicializado,
 * Quando eu verificar o estado inicial,
 * Então o elevador deve estar no andar 0 (térreo),
 * E as portas devem estar fechadas.
 * Solicitação de Andar
 *
 * Dado que eu estou dentro do elevador,
 * Quando eu pressionar o botão de um andar específico,
 * E as portas estiverem fechadas,
 * Então o elevador deve se mover para o andar solicitado,
 * E as portas devem se abrir ao chegar ao andar solicitado.
 * Chamada do Elevador
 *
 * Dado que eu estou em um andar diferente do elevador,
 * Quando eu chamar o elevador para o meu andar,
 * E as portas do elevador estiverem fechadas,
 * Então o elevador deve se mover para o meu andar,
 * E as portas devem se abrir ao chegar ao meu andar.
 * Movimento com Portas Abertas
 *
 * Dado que as portas do elevador estão abertas,
 * Quando eu tentar mover o elevador para outro andar,
 * Então o elevador não deve se mover,
 * E deve permanecer no andar atual.
 */

public class Lift {
    private int currentFloor;
    private boolean doorsOpen;
    private PriorityQueue<Integer> floorRequests;
    private PriorityQueue<Call> calls;

    public Lift() {
        this.currentFloor = 0; // Assume ground floor as starting point
        this.doorsOpen = false;
        this.floorRequests = new PriorityQueue<>();
        this.calls = new PriorityQueue<>();
    }

    public void requestFloor(int floor) {
        floorRequests.add(floor);
    }

    public void callLift(int floor, Direction direction) {
        calls.add(new Call(floor, direction));
    }

    public void openDoors() {
        doorsOpen = true;
    }

    public void closeDoors() {
        doorsOpen = false;
    }

    public void moveToNextFloor() {
        if (!doorsOpen && !floorRequests.isEmpty()) {
            currentFloor = floorRequests.poll();
            openDoors();
        }
    }

    public void attendCall() {
        if (!doorsOpen && !calls.isEmpty()) {
            Call call = calls.poll();
            currentFloor = call.getFloor();
            openDoors();
        }
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public boolean areDoorsOpen() {
        return doorsOpen;
    }

    private class Call implements Comparable<Call> {
        private int floor;
        public Call(int floor, Direction direction) {
            this.floor = floor;
        }

        public int getFloor() {
            return floor;
        }


        @Override
        public int compareTo(Call other) {
            return Integer.compare(this.floor, other.floor);
        }
    }

    public enum Direction {
        UP, DOWN
    }
}
