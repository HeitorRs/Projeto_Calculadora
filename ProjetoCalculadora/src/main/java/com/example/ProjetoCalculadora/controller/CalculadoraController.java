package com.example.ProjetoCalculadora.controller;

import com.example.ProjetoCalculadora.model.ValoresOperacao;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculadoraController {

    @GetMapping("/adicao")
    public double adicaoGet(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }

    @PostMapping("/adicao")
    public double adicaoPost(@RequestBody ValoresOperacao valores) {
        return valores.getNum1() + valores.getNum2();
    }

    @GetMapping("/subtracao")
    public double subtracaoGet(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    @PostMapping("/subtracao")
    public double subtracaoPost(@RequestBody ValoresOperacao valores) {
        return valores.getNum1() - valores.getNum2();
    }

    @GetMapping("/multiplicacao")
    public double multiplicacaoGet(@RequestParam double num1, @RequestParam double num2) {
        return num1 * num2;
    }

    @PostMapping("/multiplicacao")
    public double multiplicacaoPost(@RequestBody ValoresOperacao valores) {
        return valores.getNum1() * valores.getNum2();
    }

    @GetMapping("/divisao")
    public double divisaoGet(@RequestParam double num1, @RequestParam double num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Divizão por zero(0): inválida");
        }
        return num1 / num2;
    }

    @PostMapping("/divisao")
    public double divisaoPost(@RequestBody ValoresOperacao valores) {
        if (valores.getNum2() == 0) {
            throw new IllegalArgumentException("Divizão por zero(0): inválida");
        }
        return valores.getNum1() / valores.getNum2();
    }

    @GetMapping("/exponenciacao")
    public double exponenciacaoGet(@RequestParam double base, @RequestParam double exponent) {
        return Math.pow(base, exponent);
    }

    @PostMapping("/exponenciacao")
    public double exponenciacaoPost(@RequestBody ValoresOperacao valores) {
        return Math.pow(valores.getNum1(), valores.getNum2());
    }

}
