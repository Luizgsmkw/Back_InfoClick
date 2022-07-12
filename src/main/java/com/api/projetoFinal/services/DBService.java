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

		Produto p1 = new Produto(null, "Monitor Concórdia Gamer Curvo C32f 32\" 165hz 1ms Led Full Hd", 5.0, "O pior monitor do mundo", Categoria.HARDWARE, 1001, Status.ATIVO, "https://images.tcdn.com.br/img/img_prod/740836/monitor_concordia_gamer_curvo_c32f_32_165hz_1ms_led_full_hd_6769_1_1ee122e070f295e4eb70529e293463a7.png",
				999.99, null, null, l1);
		
		Produto p2 = new Produto(null, "Mouse Gamer Redragon - Design e performance", 105.99, "As melhores opções de Custo x Benefício: design, performance e recursos pra quem quer detonar nos Games - a Redragon tem a opção certa para você.", Categoria.HARDWARE, 1001, Status.ATIVO, "https://static.wixstatic.com/media/71a6c2_373a28191d2243aba00ef9e50c896d5d~mv2.png/v1/crop/x_0,y_246,w_1000,h_507/fill/w_960,h_480,al_c,q_90,usm_0.66_1.00_0.01,enc_auto/71a6c2_373a28191d2243aba00ef9e50c896d5d~mv2.png",
				59.99, null, null, l1);
		
		Produto p3 = new Produto(null, "Fone de Ouvido ", 105.99, "A melhor opção", Categoria.SOFTWARE, 1001, Status.ATIVO, "https://images-americanas.b2w.io/produtos/3361886476/imagens/headset-fone-ouvido-gamer-rgb-usb-p3-ps4-pc-celular/3361886492_1_large.jpg",
				159.99, null, null, l1);

		consumidorRepository.saveAll(Arrays.asList(c1, c2));
		empreendedorRepository.saveAll(Arrays.asList(e1, e2, e3));
		adminRepository.saveAll(Arrays.asList(a1));
		lojarepository.saveAll(Arrays.asList(l1));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

	}
}