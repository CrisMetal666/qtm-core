package com.jmtm.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmtm.model.MateriaPrima;
import com.jmtm.model.Venta;
import com.jmtm.model.dto.ProovedorSemana;
import com.jmtm.repository.IVentaRepository;

@Service
public class VentaService {

	@Autowired
	private IVentaRepository repo;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private MateriaPrimaService materiaPrimaService;

	public void crear(Venta venta) {

		venta.setFecha(LocalDate.now());

		repo.save(venta);
	}

	public void actualizar(Venta venta) {

		if (venta.getId() == null) {
			throw new NullPointerException("El id de la venta es nulo");
		}

		repo.save(venta);
	}

	public List<Venta> buscarVentasProovedor(Integer proovedorId) {

		if (!usuarioService.existeProovedor(proovedorId)) {
			throw new EntityNotFoundException("No existe proovedor con el id -> " + proovedorId);
		}

		return repo.buscarVentasProovedor(proovedorId);
	}

	public List<ProovedorSemana> calcularSemana() {

		LocalDate fechaActual = LocalDate.now();

		LocalDate fechaLunes = fechaActual.plusDays(1 - fechaActual.getDayOfWeek().getValue());
		
		List<Integer> lstProovedor = repo.buscarProovedoresConVentaSemana(fechaLunes, fechaActual);
		
		List<ProovedorSemana> lstProovedorVenta = new ArrayList<>();
		
		for(Integer proovedorId: lstProovedor) {
			
			String proovedorNombre = "";
			int totalDinero = 0;
			String intervaloTiempo = String.format("%s - %s", fechaLunes.toString(), fechaActual.toString());
			int totalItems = 0;

			List<Venta> lstVenta = repo.buscarVentaProovedorSemana(proovedorId, fechaLunes, fechaActual);
			MateriaPrima materiaPrima = materiaPrimaService.buscarPorUsuarioId(proovedorId);

			for (Venta venta : lstVenta) {
				
				proovedorNombre = venta.getUsuario().getNombre() + " " + venta.getUsuario().getApellido();
				totalDinero += venta.getCantidad() * materiaPrima.getPrecio();
				totalItems += venta.getCantidad();
			}

			ProovedorSemana venta = new ProovedorSemana();
			venta.setProovedorNombre(proovedorNombre);
			venta.setIntervaloTiempo(intervaloTiempo);
			venta.setTotalDinero(totalDinero);
			venta.setMateriaPrima(materiaPrima.getNombre());
			venta.setTotalItems(totalItems);
			
			lstProovedorVenta.add(venta);
			
		}

		return lstProovedorVenta;
	}

	public ProovedorSemana buscarVentasDelDia() {

		LocalDate dia = LocalDate.now();

		List<Venta> lstVenta = repo.buscarVentasDelDia(dia);

		int totalDinero = 0;
		int totalItems = 0;

		for (Venta venta : lstVenta) {

			MateriaPrima materiaPrima = materiaPrimaService.buscarPorUsuarioId(venta.getUsuario().getId());

			totalDinero += venta.getCantidad() * materiaPrima.getPrecio();
			totalItems+= venta.getCantidad();
		}

		ProovedorSemana ventasDelDia = new ProovedorSemana();

		ventasDelDia.setIntervaloTiempo(dia.toString());
		ventasDelDia.setTotalDinero(totalDinero);
		ventasDelDia.setTotalItems(totalItems);

		return ventasDelDia;
	}

	public ProovedorSemana buscarCantidadArticulosVendidos() {

		LocalDate dia = LocalDate.now();

		List<Venta> lstVenta = repo.buscarVentasDelDia(dia);

		int cantidadDeArticulos = 0;

		for (Venta venta : lstVenta) {

			cantidadDeArticulos += venta.getCantidad();
		}

		ProovedorSemana ventasDelDia = new ProovedorSemana();

		ventasDelDia.setIntervaloTiempo(dia.toString());
		ventasDelDia.setTotalItems(cantidadDeArticulos);

		return ventasDelDia;
	}
}
