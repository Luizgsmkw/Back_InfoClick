package com.api.projetoFinal.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.projetoFinal.domain.Admin;
import com.api.projetoFinal.domain.Consumidor;
import com.api.projetoFinal.domain.Empreendedor;
import com.api.projetoFinal.domain.Loja;
import com.api.projetoFinal.domain.Produto;
import com.api.projetoFinal.domain.enums.Categoria;
import com.api.projetoFinal.domain.enums.Ramo;
import com.api.projetoFinal.domain.enums.Status;
import com.api.projetoFinal.repositories.AdminRepository;
import com.api.projetoFinal.repositories.ConsumidorRepository;
import com.api.projetoFinal.repositories.EmpreendedorRepository;
import com.api.projetoFinal.repositories.LojaRepository;
import com.api.projetoFinal.repositories.ProdutoRepository;

@Service
public class DBService {

	@Autowired
	private ConsumidorRepository consumidorRepository;

	@Autowired
	private EmpreendedorRepository empreendedorRepository;

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private LojaRepository lojarepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {
		Consumidor c1 = new Consumidor(null, "Gabriel", "193.019.997-06", "gabriel@gmail.com", encoder.encode("123456"), "21992934144",
				"2271140", "Rio de Janeiro", "Rio de Janeiro", "Curicica", "Segredo", "31");
		Consumidor c2 = new Consumidor(null, "Mingau", "382.670.620-09", "mingau@gmail.com", encoder.encode("123456"), "10881823033",
				"2271140", "Rio de Janeiro", "Rio de Janeiro", "Curicica", "Segredo", "31");

		Empreendedor e1 = new Empreendedor(null, "Loja 1", "73.900.564/0001-54", "loja1@gmail.com", encoder.encode("123456"),
				"21988887777", Ramo.HARDWARE, "22720400", "Rio de Janeiro", "Rio de Janeiro", "Taquara", "maraville",
				"1155");
		Empreendedor e2 = new Empreendedor(null, "Loja 2", "86.005.261/0001-10", "loja2@gmail.com", encoder.encode("123456"),
				"21945451234", Ramo.SOFTWARE, "22720400", "Rio de Janeiro", "Rio de Janeiro", "Taquara", "Mio", "895");
		Empreendedor e3 = new Empreendedor(null, "Loja 2", "57.050.027/0001-06", "loja3@gmail.com", encoder.encode("123456"),
				"21992934155", Ramo.AMBOS, "22720400", "Rio de Janeiro", "Rio de Janeiro", "Taquara", "maraville",
				"1155");

		Admin a1 = new Admin(null, "Palloma Gulliver", "gulliver.palloma@gmail.com", encoder.encode("123456"));

		Loja l1 = new Loja(null, "Preto", "SHOPTIME", "Venda de Harware e software", e3);

		Produto p1 = new Produto(null, "Alexandre", 5.0, "Alexandre", Categoria.HARDWARE, 1001, Status.ATIVO, "blabla",
				1.0, null, null, l1);

		consumidorRepository.saveAll(Arrays.asList(c1, c2));
		empreendedorRepository.saveAll(Arrays.asList(e1, e2, e3));
		adminRepository.saveAll(Arrays.asList(a1));
		lojarepository.saveAll(Arrays.asList(l1));
		produtoRepository.saveAll(Arrays.asList(p1));

	}
}