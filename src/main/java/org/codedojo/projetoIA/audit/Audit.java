package org.codedojo.projetoIA.audit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Audit {
    
    //  Dados dos visitantes
    //      nome do visitante
    //      horário da visita
    //      arquivo de registro de visita

    // Dados dos visitantes
    private String visitorName; // nome do visitante
    private LocalDateTime visitTime; // horário da visita
    private File visitLogFile; // arquivo de registro de visita

    // Getters e Setters
    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public LocalDateTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(LocalDateTime visitTime) {
        this.visitTime = visitTime;
    }

    public File getVisitLogFile() {
        return visitLogFile;
    }

    public void setVisitLogFile(File visitLogFile) {
        this.visitLogFile = visitLogFile;
    }

    // Construtor
    public Audit(String visitorName, LocalDateTime visitTime, File visitLogFile) {
        this.visitorName = visitorName;
        this.visitTime = visitTime;
        this.visitLogFile = visitLogFile;
    }

    // Método para exibir os dados do visitante
    public void displayVisitorInfo() {
        System.out.println("Nome do Visitante: " + visitorName);
        System.out.println("Horário da Visita: " + visitTime);
        System.out.println("Arquivo de Registro de Visita: " + visitLogFile.getPath());
    }    

    //  
    //  Regras de auditoria
    //      Salvar registro de visita do visitante em um arquivo texto
    //      Salvar nome e horario
    //      Salvar no maximo 5 registros de visita por arquivo
    //      Se visita > 5, criar novo arquivo de registro de visita
    //

    // Função para salvar os dados da auditoria com as regras especificadas
    public void saveAuditRecord() throws IOException {
        int recordCount = 0;
        File currentFile = visitLogFile;

        // Contar o número de registros no arquivo atual
        if (currentFile.exists()) {
            try (Scanner scanner = new Scanner(currentFile)) {
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    recordCount++;
                }
            }
        }

        // Se o número de registros for maior ou igual a 5, criar um novo arquivo
        if (recordCount >= 5) {
            int fileIndex = 1;
            String baseName = visitLogFile.getName().replace(".txt", "");
            do {
                String newFileName = baseName + "_" + fileIndex + ".txt";
                currentFile = new File(visitLogFile.getParent(), newFileName);
                fileIndex++;
            } while (currentFile.exists() && countRecords(currentFile) >= 5);
        }

        // Escrever o registro no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile, true))) {
            writer.write("Nome do Visitante: " + visitorName + ", Horário da Visita: " + visitTime.toString());
            writer.newLine();
        }
    }

    // Método auxiliar para contar registros em um arquivo
    public int countRecords(File file) throws IOException {
        int count = 0;
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNextLine()) {
                    scanner.nextLine();
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Criar um arquivo de registro de visita
        File visitLogFile = new File("visit_log.txt");

        // Loop para criar 50 registros de auditoria
        for (int i = 1; i <= 50; i++) {
            // Criar uma instância da classe Audit com um nome de visitante e horário diferentes
            Audit audit = new Audit("Visitor " + i, LocalDateTime.now(), visitLogFile);

            // Salvar o registro de auditoria
            try {
                audit.saveAuditRecord();
                System.out.println("Registro de auditoria " + i + " salvo com sucesso.");
            } catch (IOException e) {
                System.err.println("Erro ao salvar o registro de auditoria " + i + ": " + e.getMessage());
            }

            // Exibir as informações do visitante
            audit.displayVisitorInfo();
        }
    }

    // calculo da media do aluno
    public double calcularMedia(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }
}
