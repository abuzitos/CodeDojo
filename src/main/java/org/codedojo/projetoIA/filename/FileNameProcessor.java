package org.codedojo.projetoIA.filename;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileNameProcessor {
 
    /**
     * Nome do metodo: grupoPalavras
     * 
     * Input: "tests", "spec", "test", "steps"
     * 
     * Processamento:
     *      - Adicionar caracteres ".", "-", "_" no inicio e fim de cada palavra do array
     * 
     * Output: Array com somente palavras + palavras com os caracteres
     * 
     */
    public List<String> grupoPalavras(String... palavras) {
        List<String> listaPalavras = new ArrayList<>();
        for (String palavra : palavras) {
            listaPalavras.add(palavra);
            listaPalavras.add("." + palavra);
            listaPalavras.add("-" + palavra);
            listaPalavras.add("_" + palavra);
            listaPalavras.add(palavra + ".");
            listaPalavras.add(palavra + "-");
            listaPalavras.add(palavra + "_");
        }
        return listaPalavras;
    }

    /**
     * Nome do metodo: listaDePalavras
     * 
     * Input: Array de palavras
     * 
     * Processamento:
     *      - Criar uma lista de palavras com o metodo grupoPalavras
     *      - Ordenar as palavras.
     *      - Utilizar um comparador para ordenar as palavras com base no comprimento.
     *      - Retornar a lista ordenada.
     * 
     * Output: Array de palavras
     */
    public List<String> listaDePalavras(String... palavras) {
        List<String> listaPalavras = grupoPalavras(palavras);
        listaPalavras.sort((a, b) -> Integer.compare(b.length(), a.length()));
        return listaPalavras;
    }

    /**
     * Remover palavras comuns de testes
     * 
     * Input: String com o nome do arquivo
     * 
     * Processamento:
     *      - Criar uma lista de palavras com o metodo listaDePalavras
     *      - Remover palavras comuns de testes
     * 
     * Output: Nome do arquivo sem palavras comuns de testes
     */
    public String removeTestWords(String nomeArquivo) {
        List<String> palavras = listaDePalavras("tests", "spec", "test", "steps", "Test", "Spec", "Tests", "Specs");
        for (String palavra : palavras) {
            if (nomeArquivo.contains(palavra)) {
                nomeArquivo = nomeArquivo.replace(palavra, "");
            }
        }
        return nomeArquivo;
    }


    /**
     * Nome do metodo: removePathFile
     * 
     * Input: String com o caminho do arquivo
     * 
     * Processamento:
     *     - Remover o path do arquivo
     * 
     * Output: Nome do arquivo com extensão
     */
    public static String removePathFile(String arquivo) {
        return arquivo.substring(arquivo.lastIndexOf("/") + 1);
    }

    /**
     * Nome do metodo: removeExtension
     * 
     * Input: String com o nome do arquivo
     * 
     * Processamento:
     *     - Remover a extensão do arquivo
     * 
     * Output: Nome do arquivo sem extensão
     */
    public static String removeExtension(String nomeArquivo) {
        int index = nomeArquivo.lastIndexOf(".");
        if (index != -1) {
            nomeArquivo = nomeArquivo.substring(0, index);
        }
        return nomeArquivo;
    }

    /**
     * Processar o nome do arquivo
     * 
     * Input: Array com a lista de arquivos
     * 
     * Processamento:
     *      - Remover o path do arquivo
     *      - Remover a extensão do arquivo, se houver
     *      - Remover sufixos comuns de testes (metodo: grupoPalavras)
     * 
     * Output: Nome do arquivo
     */
    public List<String> processarNomeArquivo(String[] arquivosComPath) {
        List<String> nomesSemExtensao = new ArrayList<>();
        for (String arquivo : arquivosComPath) {
            String nomeArquivo = removePathFile(arquivo);
            nomeArquivo = removeExtension(nomeArquivo);
            nomeArquivo = removeTestWords(nomeArquivo);
            nomesSemExtensao.add(nomeArquivo);
        }
        return nomesSemExtensao;
    }

    /**
     *  Compara nome do arquivo gerado ao resultado esperado
     * 
     *  input: nome gerado e nome esperado
     * 
     *  processamento: compara se os nomes são iguais
     * 
     *  output: imprime se os nomes são iguais ou diferentes
     */
    public void compararNomes(String nomeGerado, String nomeEsperado) {
        if (nomeGerado.equals(nomeEsperado)) {
            System.out.println("Nome gerado: " + nomeGerado + " é igual ao nome esperado: " + nomeEsperado);
        } else {
            System.out.println("Nome gerado: " + nomeGerado + " é diferente do nome esperado: " + nomeEsperado);
            System.out.println("*****");
        }
    }

    public static void main(String[] args) {
        FileNameProcessor processor = new FileNameProcessor();
        String[] arquivosComPath = {
            "src/Hiker_spec.re", "test/hiker_test.exs", "wibble/test/hiker_spec.rb",
            "hiker_steps.rb", "hiker_spec.rb", "test_hiker.rb", "test_hiker.py",
            "test_hiker.sh", "tests_hiker.sh", "test_hiker.coffee", "hiker_spec.coffee",
            "hikerTest.chpl", "hiker.tests.c", "hiker_tests.c", "hiker_test.c",
            "hiker_Test.c", "HikerTests.cpp", "hikerTests.cpp", "HikerTest.cs",
            "HikerTest.java", "DiamondTest.kt", "HikerTest.php", "hikerTest.js",
            "hiker-test.js", "hiker-spec.js", "hiker.test.js", "hiker.tests.ts",
            "hiker_tests.erl", "hiker_test.clj", "fizzBuzz_test.d", "hiker_test.go",
            "hiker.tests.R", "hikertests.swift", "HikerSpec.groovy", "hikerSpec.feature",
            "hiker.feature", "hiker.fun", "hiker.t", "hiker.plt", "hiker"
        };

        List<String> nomesEsperados = Arrays.asList(
            "Hiker", "hiker", "hiker", "hiker", "hiker", "hiker", "hiker",
            "hiker", "hiker", "hiker", "hiker", "hiker", "hiker", "hiker",
            "hiker", "hiker", "Hiker", "hiker", "Hiker", "Hiker", "Diamond",
            "Hiker", "hiker", "hiker", "hiker", "hiker", "hiker", "hiker",
            "hiker", "fizzBuzz", "hiker", "hiker", "hiker", "Hiker", "hiker",
            "hiker", "hiker", "hiker", "hiker", "hiker"
        );

        List<String> nomesGerados = processor.processarNomeArquivo(arquivosComPath);

        for (int i = 0; i < nomesGerados.size(); i++) {
            String nomeGerado = nomesGerados.get(i);
            String nomeEsperado = nomesEsperados.get(i);
            processor.compararNomes(nomeGerado, nomeEsperado);
        }
    }
}
