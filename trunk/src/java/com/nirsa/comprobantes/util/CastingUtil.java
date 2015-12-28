/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nirsa.comprobantes.util;

import com.nirsa.comprobantes.modelo.CampoAdicional;
import com.nirsa.comprobantes.modelo.DetAdicional;
import com.nirsa.comprobantes.modelo.DetallesAdicionales;
import com.nirsa.comprobantes.modelo.Impuesto;
import com.nirsa.comprobantes.modelo.Impuestos;
import com.nirsa.comprobantes.modelo.InfoAdicional;
import com.nirsa.comprobantes.modelo.InfoTributaria;
import com.nirsa.comprobantes.modelo.factura.Factura;
import com.nirsa.comprobantes.modelo.factura.FacturaDetalle;
import com.nirsa.comprobantes.modelo.factura.FacturaDetalleDetalles;
import com.nirsa.comprobantes.modelo.factura.InfoFactura;
import com.nirsa.comprobantes.modelo.factura.TotalConImpuestos;
import com.nirsa.comprobantes.modelo.factura.TotalImpuesto;
import com.nirsa.comprobantes.modelo.guia.Destinatario;
import com.nirsa.comprobantes.modelo.guia.Destinatarios;
import com.nirsa.comprobantes.modelo.guia.GuiaDetalles;
import com.nirsa.comprobantes.modelo.guia.GuiaDetallesDetalle;
import com.nirsa.comprobantes.modelo.guia.GuiaRemision;
import com.nirsa.comprobantes.modelo.guia.InfoGuiaRemision;
import com.nirsa.comprobantes.modelo.notacredito.Detalle;
import com.nirsa.comprobantes.modelo.notacredito.Detalles;
import com.nirsa.comprobantes.modelo.notacredito.InfoNotaCredito;
import com.nirsa.comprobantes.modelo.notacredito.NotaCredito;
import com.nirsa.comprobantes.modelo.notadebito.InfoNotaDebito;
import com.nirsa.comprobantes.modelo.notadebito.Motivo;
import com.nirsa.comprobantes.modelo.notadebito.Motivos;
import com.nirsa.comprobantes.modelo.notadebito.NotaDebito;
import com.nirsa.comprobantes.ws.modelo.factura.FacturaDetalleWS;
import com.nirsa.comprobantes.ws.modelo.factura.FacturaWS;
import com.nirsa.comprobantes.ws.modelo.CampoAdicionalWS;
import com.nirsa.comprobantes.ws.modelo.DestinatarioDetallesWS;
import com.nirsa.comprobantes.ws.modelo.DetAdicionalWS;
import com.nirsa.comprobantes.ws.modelo.ImpuestoWS;
import com.nirsa.comprobantes.ws.modelo.TotalImpuestoWS;
import com.nirsa.comprobantes.ws.modelo.guia.DestinatarioWS;
import com.nirsa.comprobantes.ws.modelo.guia.GuiaRemisionWS;
import com.nirsa.comprobantes.ws.modelo.notacredito.NotaCreditoDetalles;
import com.nirsa.comprobantes.ws.modelo.notacredito.NotaCreditoWS;
import com.nirsa.comprobantes.ws.modelo.notadebito.MotivoWS;
import com.nirsa.comprobantes.ws.modelo.notadebito.NotaDebitoWS;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rolando
 */
public class CastingUtil {

    public static Object[] convertirNotaDebitoWSaDebito(NotaDebitoWS notaDebitoWS) {
        Object[] resultado = new Object[2];
        resultado[1] = "";
        NotaDebito notaDebito = new NotaDebito();
        try {
            //----------------------
            //Información tributaria
            //----------------------
            InfoTributaria infoTributaria = new InfoTributaria();
            infoTributaria.setRazonSocial(notaDebitoWS.getRazonSocial());
            infoTributaria.setNombreComercial(notaDebitoWS.getNombreComercial());
            infoTributaria.setRuc(notaDebitoWS.getRuc());
            String tipoComprobante = notaDebitoWS.getCodDoc();
            String ruc = notaDebitoWS.getRuc();
            String ambiente = notaDebitoWS.getAmbiente();
            String serie = notaDebitoWS.getEstab().concat(notaDebitoWS.getEstab());
            String numeroComprobante = notaDebitoWS.getSecuencial();
            String codigoNumerico = "12345678";
            String tipoEmision = notaDebitoWS.getTipoEmision();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaEmision = dateFormat.parse(notaDebitoWS.getFechaEmision());
            String claveAcceso = ClaveDeAcceso.generarClaveAcceso(fechaEmision, tipoComprobante, ruc, ambiente, serie, numeroComprobante, codigoNumerico, tipoEmision);
            if (claveAcceso == null) {
                resultado[0] = null;
                resultado[1] = Mensajes.CLAVE_ACCESO_MAL_FORMADA;
                return resultado;
            }
            infoTributaria.setClaveAcceso(claveAcceso);
            infoTributaria.setCodDoc(notaDebitoWS.getCodDoc());
            infoTributaria.setEstab(notaDebitoWS.getEstab());
            infoTributaria.setPtoEmi(notaDebitoWS.getPtoEmi());
            infoTributaria.setSecuencial(notaDebitoWS.getSecuencial());
            infoTributaria.setDirMatriz(notaDebitoWS.getDirMatriz());
            infoTributaria.setAmbiente(notaDebitoWS.getAmbiente());
            infoTributaria.setTipoEmision(notaDebitoWS.getTipoEmision());
            infoTributaria.setNombreComercial(notaDebitoWS.getNombreComercial());
            notaDebito.setInfoTributaria(infoTributaria);

            InfoNotaDebito ind = new InfoNotaDebito();
            ind.setId(notaDebitoWS.getId());
            ind.setVersion(notaDebitoWS.getVersion());
            ind.setFechaEmision(notaDebitoWS.getFechaEmision());
            ind.setDirEstablecimiento(notaDebitoWS.getDirEstablecimiento());
            ind.setTipoIdentificacionComprador(notaDebitoWS.getTipoIdentificacionComprador());
            ind.setRazonSocialComprador(notaDebitoWS.getRazonSocialComprador());
            ind.setIdentificacionComprador(notaDebitoWS.getIdentificacionComprador());
            ind.setContribuyenteEspecial(notaDebitoWS.getContribuyenteEspecial());
            ind.setObligadoContabilidad(notaDebitoWS.getObligadoContabilidad());
            ind.setRise(notaDebitoWS.getRise());
            ind.setCodDocModificado(notaDebitoWS.getCodDocModificado());
            ind.setNumDocModificado(notaDebitoWS.getNumDocModificado());
            ind.setFechaEmisionDocSustento(notaDebitoWS.getFechaEmisionDocSustento());
            ind.setTotalSinImpuestos(notaDebitoWS.getTotalSinImpuestos());
            ind.setValorTotal(notaDebitoWS.getValorTotal());
            //Impuestos
            Impuestos i = new Impuestos();
            List<Impuesto> listaImpuestos = new ArrayList<Impuesto>();
            List<ImpuestoWS> lstImpuestos = notaDebitoWS.getImpuestos();
            for (ImpuestoWS impuestoWS : lstImpuestos) {
                Impuesto ip = new Impuesto();
                ip.setCodigo(impuestoWS.getCodigo());
                ip.setCodigoPorcentaje(impuestoWS.getCodigoPorcentaje());
                ip.setTarifa(impuestoWS.getTarifa());
                ip.setBaseImponible(impuestoWS.getBaseImponible());
                ip.setValor(impuestoWS.getValor());
                listaImpuestos.add(ip);
            }
            i.setImpuesto(listaImpuestos);
            ind.setImpuestos(i);
            notaDebito.setInfoNotaDebito(ind);

            Motivos ms = new Motivos();
            List<Motivo> listaMotivos = new ArrayList<Motivo>();
            List<MotivoWS> lstMotivos = notaDebitoWS.getMotivos();
            for (MotivoWS motivoWS : lstMotivos) {
                Motivo m = new Motivo();
                m.setRazon(motivoWS.getRazon());
                m.setValor(motivoWS.getValor());
                listaMotivos.add(m);
            }
            ms.setMotivo(listaMotivos);
            notaDebito.setMotivos(ms);
            List<CampoAdicional> lstCamposAdicionales = new ArrayList<CampoAdicional>();
            List<CampoAdicionalWS> camposAdicionales = notaDebitoWS.getListaCamposAdicionales();
            if (camposAdicionales != null) {
                for (CampoAdicionalWS campoAdicionalWS : camposAdicionales) {
                    CampoAdicional ca = new CampoAdicional();
                    ca.setNombre(campoAdicionalWS.getNombre());
                    ca.setValue(campoAdicionalWS.getValue());
                    lstCamposAdicionales.add(ca);
                }
            }
            InfoAdicional ia = new InfoAdicional();
            ia.setCampoAdicional(lstCamposAdicionales);
            notaDebito.setInfoAdicional(ia);
            resultado[0] = notaDebito;
        } catch (Exception e) {
            resultado[0] = null;
            resultado[1] = ExceptionUtils.getStackTrace(e);
        }
        return resultado;
    }

    public static Object[] convertirNotaCreditoWSaNotaCredito(NotaCreditoWS notaCreditoWS) {
        Object[] resultado = new Object[2];
        resultado[1] = "";
        NotaCredito notaCredito = new NotaCredito();
        try {
            //----------------------
            //Información tributaria
            //----------------------
            InfoTributaria infoTributaria = new InfoTributaria();
            infoTributaria.setRazonSocial(notaCreditoWS.getRazonSocial());
            infoTributaria.setNombreComercial(notaCreditoWS.getNombreComercial());
            infoTributaria.setRuc(notaCreditoWS.getRuc());
            String tipoComprobante = notaCreditoWS.getCodDoc();
            String ruc = notaCreditoWS.getRuc();
            String ambiente = notaCreditoWS.getAmbiente();
            String serie = notaCreditoWS.getEstab().concat(notaCreditoWS.getEstab());
            String numeroComprobante = notaCreditoWS.getSecuencial();
            String codigoNumerico = "12345678";
            String tipoEmision = notaCreditoWS.getTipoEmision();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaEmision = dateFormat.parse(notaCreditoWS.getFechaEmision());
            String claveAcceso = ClaveDeAcceso.generarClaveAcceso(fechaEmision, tipoComprobante, ruc, ambiente, serie, numeroComprobante, codigoNumerico, tipoEmision);
            if (claveAcceso == null) {
                resultado[0] = null;
                resultado[1] = Mensajes.CLAVE_ACCESO_MAL_FORMADA;
                return resultado;
            }
            infoTributaria.setClaveAcceso(claveAcceso);
            infoTributaria.setCodDoc(notaCreditoWS.getCodDoc());
            infoTributaria.setEstab(notaCreditoWS.getEstab());
            infoTributaria.setPtoEmi(notaCreditoWS.getPtoEmi());
            infoTributaria.setSecuencial(notaCreditoWS.getSecuencial());
            infoTributaria.setDirMatriz(notaCreditoWS.getDirMatriz());
            infoTributaria.setAmbiente(notaCreditoWS.getAmbiente());
            infoTributaria.setTipoEmision(notaCreditoWS.getTipoEmision());
            infoTributaria.setNombreComercial(notaCreditoWS.getNombreComercial());
            notaCredito.setInfoTributaria(infoTributaria);
            //---------------------------------
            //Información de la nota de crédito
            //---------------------------------
            InfoNotaCredito in = new InfoNotaCredito();
            in.setFechaEmision(notaCreditoWS.getFechaEmision());
            in.setDirEstablecimiento(notaCreditoWS.getDirEstablecimiento());
            in.setTipoIdentificacionComprador(notaCreditoWS.getTipoIdentificacionComprador());
            in.setRazonSocialComprador(notaCreditoWS.getRazonSocialComprador());
            in.setIdentificacionComprador(notaCreditoWS.getIdentificacionComprador());
            in.setContribuyenteEspecial(notaCreditoWS.getContribuyenteEspecial());
            in.setObligadoContabilidad(notaCreditoWS.getObligadoContabilidad());
            in.setRise(notaCreditoWS.getRise());
            in.setCodDocModificado(notaCreditoWS.getCodDocModificado());
            in.setNumDocModificado(notaCreditoWS.getNumDocModificado());
            in.setFechaEmisionDocSustento(notaCreditoWS.getFechaEmisionDocSustento());
            in.setTotalSinImpuestos(notaCreditoWS.getTotalSinImpuestos());
            in.setValorModificacion(notaCreditoWS.getValorModificacion());
            in.setMoneda(notaCreditoWS.getMoneda());
            in.setMotivo(notaCreditoWS.getMotivo());
            List<com.nirsa.comprobantes.modelo.notacredito.TotalImpuesto> listaTotalImpuesto = new ArrayList<com.nirsa.comprobantes.modelo.notacredito.TotalImpuesto>();
            List<TotalImpuestoWS> lstTotalImpuesto = notaCreditoWS.getTotalImpuesto();
            for (TotalImpuestoWS totalImpuestoWS : lstTotalImpuesto) {
                com.nirsa.comprobantes.modelo.notacredito.TotalImpuesto ti = new com.nirsa.comprobantes.modelo.notacredito.TotalImpuesto();
                ti.setCodigo(totalImpuestoWS.getCodigo());
                ti.setCodigoPorcentaje(totalImpuestoWS.getCodigoPorcentaje());
                ti.setBaseImponible(totalImpuestoWS.getBaseImponible());
                ti.setValor(totalImpuestoWS.getValor());
                listaTotalImpuesto.add(ti);
            }
            com.nirsa.comprobantes.modelo.notacredito.TotalConImpuestos tci = new com.nirsa.comprobantes.modelo.notacredito.TotalConImpuestos();
            tci.setTotalImpuesto(listaTotalImpuesto);
            in.setTotalConImpuestos(tci);
            notaCredito.setInfoNotaCredito(in);

            List<Detalle> listaDetalles = new ArrayList<Detalle>();
            List<NotaCreditoDetalles> lstDetalles = notaCreditoWS.getDetalle();
            for (NotaCreditoDetalles ncd : lstDetalles) {
                Detalle d = new Detalle();
                d.setCodigoInterno(ncd.getCodigoInterno());
                d.setCodigoAdicional(ncd.getCodigoAdicional());
                d.setDescripcion(ncd.getDescripcion());
                d.setCantidad(ncd.getCantidad());
                d.setPrecioUnitario(ncd.getPrecioUnitario());
                d.setDescuento(ncd.getDescuento());
                d.setPrecioTotalSinImpuesto(ncd.getPrecioTotalSinImpuesto());
                List<DetAdicionalWS> lstDetallesAdicionales = ncd.getDetallesAdicionales();
                List<DetAdicional> listaDetallesAdicionales = new ArrayList<DetAdicional>();
                for (DetAdicionalWS detAdicionalWS : lstDetallesAdicionales) {
                    DetAdicional da = new DetAdicional();
                    da.setNombre(detAdicionalWS.getNombre());
                    da.setValor(detAdicionalWS.getValor());
                    listaDetallesAdicionales.add(da);
                }
                DetallesAdicionales das = new DetallesAdicionales();
                das.setDetAdicional(listaDetallesAdicionales);
                d.setDetallesAdicionales(das);

                Impuestos impuestos = new Impuestos();
                List<ImpuestoWS> impuestosDetalle = ncd.getImpuestos();
                List<Impuesto> lstImpuestos = new ArrayList<Impuesto>();
                for (ImpuestoWS impuesto : impuestosDetalle) {
                    Impuesto i = new Impuesto();
                    i.setCodigo(impuesto.getCodigo());
                    i.setCodigoPorcentaje(impuesto.getCodigoPorcentaje());
                    i.setTarifa(impuesto.getTarifa());
                    i.setBaseImponible(impuesto.getBaseImponible());
                    i.setValor(impuesto.getValor());
                    lstImpuestos.add(i);
                }
                impuestos.setImpuesto(lstImpuestos);
                d.setImpuestos(impuestos);
                listaDetalles.add(d);
            }
            Detalles detalles = new Detalles();
            detalles.setDetalle(listaDetalles);
            notaCredito.setDetalles(detalles);

            List<CampoAdicional> lstCamposAdicionales = new ArrayList<CampoAdicional>();
            List<CampoAdicionalWS> camposAdicionales = notaCreditoWS.getListaCamposAdicionales();
            if (camposAdicionales != null) {
                for (CampoAdicionalWS campoAdicionalWS : camposAdicionales) {
                    CampoAdicional ca = new CampoAdicional();
                    ca.setNombre(campoAdicionalWS.getNombre());
                    ca.setValue(campoAdicionalWS.getValue());
                    lstCamposAdicionales.add(ca);
                }
            }
            InfoAdicional ia = new InfoAdicional();
            ia.setCampoAdicional(lstCamposAdicionales);
            notaCredito.setInfoAdicional(ia);
            notaCredito.setId(notaCreditoWS.getId());
            notaCredito.setVersion(notaCreditoWS.getVersion());
            resultado[0] = notaCredito;
        } catch (Exception e) {
            resultado[0] = null;
            resultado[1] = ExceptionUtils.getStackTrace(e);
        }
        return resultado;
    }

    public static Object[] convertirGuiaRemisionWSaGuiaRemision(GuiaRemisionWS guiaRemisionWS) {
        Object[] resultado = new Object[2];
        resultado[1] = "";
        GuiaRemision guiaRemision = new GuiaRemision();
        try {
            //----------------------
            //Información tributaria
            //----------------------
            InfoTributaria infoTributaria = new InfoTributaria();
            infoTributaria.setRazonSocial(guiaRemisionWS.getRazonSocial());
            infoTributaria.setNombreComercial(guiaRemisionWS.getNombreComercial());
            infoTributaria.setRuc(guiaRemisionWS.getRuc());
            String tipoComprobante = guiaRemisionWS.getCodDoc();
            String ruc = guiaRemisionWS.getRuc();
            String ambiente = guiaRemisionWS.getAmbiente();
            String serie = guiaRemisionWS.getEstab().concat(guiaRemisionWS.getEstab());
            String numeroComprobante = guiaRemisionWS.getSecuencial();
            String codigoNumerico = "12345678";
            String tipoEmision = guiaRemisionWS.getTipoEmision();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaEmision = dateFormat.parse(guiaRemisionWS.getFechaEmision());
            String claveAcceso = ClaveDeAcceso.generarClaveAcceso(fechaEmision, tipoComprobante, ruc, ambiente, serie, numeroComprobante, codigoNumerico, tipoEmision);
            if (claveAcceso == null) {
                resultado[0] = null;
                resultado[1] = Mensajes.CLAVE_ACCESO_MAL_FORMADA;
                return resultado;
            }
            infoTributaria.setClaveAcceso(claveAcceso);
            infoTributaria.setCodDoc(guiaRemisionWS.getCodDoc());
            infoTributaria.setEstab(guiaRemisionWS.getEstab());
            infoTributaria.setPtoEmi(guiaRemisionWS.getPtoEmi());
            infoTributaria.setSecuencial(guiaRemisionWS.getSecuencial());
            infoTributaria.setDirMatriz(guiaRemisionWS.getDirMatriz());
            infoTributaria.setAmbiente(guiaRemisionWS.getAmbiente());
            infoTributaria.setTipoEmision(guiaRemisionWS.getTipoEmision());
            guiaRemision.setInfoTributaria(infoTributaria);

            //-------------------------------
            //Información de guia de remisión
            //-------------------------------
            InfoGuiaRemision infoGuia = new InfoGuiaRemision();
            infoGuia.setDirEstablecimiento(guiaRemisionWS.getDirEstablecimiento());
            infoGuia.setDirPartida(guiaRemisionWS.getDirPartida());
            infoGuia.setRazonSocialTransportista(guiaRemisionWS.getRazonSocialTransportista());
            infoGuia.setTipoIdentificacionTransportista(guiaRemisionWS.getTipoIdentificacionTransportista());
            infoGuia.setRucTransportista(guiaRemisionWS.getRucTransportista());
            infoGuia.setRise(guiaRemisionWS.getRise());
            infoGuia.setObligadoContabilidad(guiaRemisionWS.getObligadoContabilidad());
            infoGuia.setContribuyenteEspecial(guiaRemisionWS.getContribuyenteEspecial());
            infoGuia.setFechaIniTransporte(guiaRemisionWS.getFechaIniTransporte());
            infoGuia.setFechaFinTransporte(guiaRemisionWS.getFechaFinTransporte());
            infoGuia.setPlaca(guiaRemisionWS.getPlaca());
            guiaRemision.setInfoGuiaRemision(infoGuia);

            //-------------
            //Destinatarios
            //-------------
            Destinatarios destinatarios = new Destinatarios();
            List<Destinatario> listaDestinatarios = new ArrayList<Destinatario>();
            List<DestinatarioWS> lstDestinatarios = guiaRemisionWS.getListaDestinatarios();
            for (DestinatarioWS dws : lstDestinatarios) {
                Destinatario d = new Destinatario();
                d.setIdentificacionDestinatario(dws.getIdentificacionDestinatario());
                d.setRazonSocialDestinatario(dws.getRazonSocialDestinatario());
                d.setDirDestinatario(dws.getDirDestinatario());
                d.setMotivoTraslado(dws.getMotivoTraslado());
                d.setDocAduaneroUnico(dws.getDocAduaneroUnico());
                d.setCodEstabDestino(dws.getCodEstabDestino());
                d.setRuta(dws.getRuta());
                d.setCodDocSustento(dws.getCodDocSustento());
                d.setNumDocSustento(dws.getNumDocSustento());
                d.setNumAutDocSustento(dws.getNumAutDocSustento());
                d.setFechaEmisionDocSustento(dws.getFechaEmisionDocSustento());

                List<GuiaDetallesDetalle> listaDetalles = new ArrayList<GuiaDetallesDetalle>();
                List<DestinatarioDetallesWS> lstDetalles = dws.getListaDetalles();
                for (DestinatarioDetallesWS dd : lstDetalles) {
                    GuiaDetallesDetalle gdd = new GuiaDetallesDetalle();
                    gdd.setCodigoInterno(dd.getCodigoInterno());
                    gdd.setCodigoAdicional(dd.getCodigoAdicional());
                    gdd.setDescripcion(dd.getDescripcion());
                    gdd.setCantidad(dd.getCantidad());
                    List<DetAdicional> listaDetallesAdicionales = new ArrayList<DetAdicional>();
                    List<DetAdicionalWS> lstDetallesAdicionales = dd.getListaDetallesAdicionales();
                    for (DetAdicionalWS detAdicionalWS : lstDetallesAdicionales) {
                        DetAdicional da = new DetAdicional();
                        da.setNombre(detAdicionalWS.getNombre());
                        da.setValor(detAdicionalWS.getValor());
                        listaDetallesAdicionales.add(da);
                    }
                    DetallesAdicionales das = new DetallesAdicionales();
                    das.setDetAdicional(listaDetallesAdicionales);
                    listaDetalles.add(gdd);
                }
                GuiaDetalles gds = new GuiaDetalles();
                gds.setDetalle(listaDetalles);
                d.setDetalles(gds);
                listaDestinatarios.add(d);
            }
            destinatarios.setDestinatario(listaDestinatarios);
            guiaRemision.setDestinatarios(destinatarios);

            guiaRemision.setId(guiaRemisionWS.getId());
            guiaRemision.setVersion(guiaRemisionWS.getVersion());
            resultado[0] = guiaRemision;
        } catch (Exception e) {
            resultado[0] = null;
            resultado[1] = ExceptionUtils.getStackTrace(e);
        }
        return resultado;
    }

    public static Object[] convertirFacturaWSaFactura(FacturaWS facturaWS) {
        Object[] resultado = new Object[2];
        resultado[1] = "";
        Factura factura = new Factura();
        try {
            //----------------------
            //Información tributaria
            //----------------------
            InfoTributaria infoTributaria = new InfoTributaria();
            infoTributaria.setRazonSocial(facturaWS.getRazonSocial());
            infoTributaria.setNombreComercial(facturaWS.getNombreComercial());
            infoTributaria.setRuc(facturaWS.getRuc());
            String tipoComprobante = facturaWS.getCodDoc();
            String ruc = facturaWS.getRuc();
            String ambiente = facturaWS.getAmbiente();
            String serie = facturaWS.getEstab().concat(facturaWS.getEstab());
            String numeroComprobante = facturaWS.getSecuencial();
            String codigoNumerico = "12345678";
            String tipoEmision = facturaWS.getTipoEmision();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaEmision = dateFormat.parse(facturaWS.getFechaEmision());
            String claveAcceso = ClaveDeAcceso.generarClaveAcceso(fechaEmision, tipoComprobante, ruc, ambiente, serie, numeroComprobante, codigoNumerico, tipoEmision);
            if (claveAcceso == null) {
                resultado[0] = null;
                resultado[1] = Mensajes.CLAVE_ACCESO_MAL_FORMADA;
                return resultado;
            }
            infoTributaria.setClaveAcceso(claveAcceso);
            infoTributaria.setCodDoc(facturaWS.getCodDoc());
            infoTributaria.setEstab(facturaWS.getEstab());
            infoTributaria.setPtoEmi(facturaWS.getPtoEmi());
            infoTributaria.setSecuencial(facturaWS.getSecuencial());
            infoTributaria.setDirMatriz(facturaWS.getDirMatriz());
            infoTributaria.setAmbiente(facturaWS.getAmbiente());
            infoTributaria.setTipoEmision(facturaWS.getTipoEmision());
            factura.setInfoTributaria(infoTributaria);
            //--------------------------
            //Información de factura
            //--------------------------
            InfoFactura infoFactura = new InfoFactura();
            infoFactura.setFechaEmision(facturaWS.getFechaEmision());
            infoFactura.setDirEstablecimiento(facturaWS.getDirEstablecimiento());
            infoFactura.setContribuyenteEspecial(facturaWS.getContribuyenteEspecial());
            infoFactura.setObligadoContabilidad(facturaWS.getObligadoContabilidad());
            infoFactura.setTipoIdentificacionComprador(facturaWS.getTipoIdentificacionComprador());
            infoFactura.setRazonSocialComprador(facturaWS.getRazonSocialComprador());
            infoFactura.setIdentificacionComprador(facturaWS.getIdentificacionComprador());
            infoFactura.setTotalSinImpuestos(facturaWS.getTotalSinImpuestos());
            infoFactura.setTotalDescuento(facturaWS.getTotalDescuento());
            List<TotalImpuestoWS> listaTotalmpuestos = facturaWS.getListaTotalImpuestos();
            TotalConImpuestos totalConImpuesto = new TotalConImpuestos();
            List<TotalImpuesto> lstTotalmpuestos = new ArrayList<TotalImpuesto>();
            if (listaTotalmpuestos != null) {
                for (TotalImpuestoWS totalImpuestoWS : listaTotalmpuestos) {
                    TotalImpuesto ti = new TotalImpuesto();
                    ti.setCodigo(totalImpuestoWS.getCodigo());
                    ti.setCodigoPorcentaje(totalImpuestoWS.getCodigoPorcentaje());
                    ti.setValor(totalImpuestoWS.getValor());
                    ti.setBaseImponible(totalImpuestoWS.getBaseImponible());
                    ti.setTarifa(totalImpuestoWS.getTarifa());
                    lstTotalmpuestos.add(ti);
                }
            }
            totalConImpuesto.setTotalImpuesto(lstTotalmpuestos);
            infoFactura.setTotalConImpuestos(totalConImpuesto);
            infoFactura.setPropina(facturaWS.getPropina());
            infoFactura.setImporteTotal(facturaWS.getImporteTotal());
            infoFactura.setMoneda(facturaWS.getMoneda());
            factura.setInfoFactura(infoFactura);
            //------------------------------------------------------------------
            //Detalles de factura
            //------------------------------------------------------------------
            FacturaDetalleDetalles detalles = new FacturaDetalleDetalles();
            List<FacturaDetalleWS> detallesFactura = facturaWS.getListaDetalles();
            List<FacturaDetalle> lstDetallesFactura = new ArrayList<FacturaDetalle>();
            if (detallesFactura != null) {
                for (FacturaDetalleWS facturaDetalleWS : detallesFactura) {
                    FacturaDetalle d = new FacturaDetalle();
                    d.setCodigoPrincipal(facturaDetalleWS.getCodigoPrincipal());
                    d.setCodigoAuxiliar(facturaDetalleWS.getCodigoAuxiliar());
                    d.setDescripcion(facturaDetalleWS.getDescripcion());
                    d.setCantidad(facturaDetalleWS.getCantidad());
                    d.setPrecioUnitario(facturaDetalleWS.getPrecioUnitario());
                    d.setDescuento(facturaDetalleWS.getDescuento());
                    d.setPrecioTotalSinImpuesto(facturaDetalleWS.getPrecioTotalSinImpuesto());
                    Impuestos impuestos = new Impuestos();
                    List<ImpuestoWS> impuestosDetalle = facturaDetalleWS.getListaImpuestos();
                    List<Impuesto> lstImpuestos = new ArrayList<Impuesto>();
                    for (ImpuestoWS impuesto : impuestosDetalle) {
                        Impuesto i = new Impuesto();
                        i.setCodigo(impuesto.getCodigo());
                        i.setCodigoPorcentaje(impuesto.getCodigoPorcentaje());
                        i.setTarifa(impuesto.getTarifa());
                        i.setBaseImponible(impuesto.getBaseImponible());
                        i.setValor(impuesto.getValor());
                        lstImpuestos.add(i);
                    }
                    impuestos.setImpuesto(lstImpuestos);
                    d.setImpuestos(impuestos);
                    lstDetallesFactura.add(d);
                }
            }
            detalles.setDetalle(lstDetallesFactura);
            factura.setDetalles(detalles);
            //------------------------------------------------------------------
            //Información adicional
            //------------------------------------------------------------------
            List<CampoAdicional> lstCamposAdicionales = new ArrayList<CampoAdicional>();
            List<CampoAdicionalWS> camposAdicionales = facturaWS.getListaCamposAdicionales();
            if (camposAdicionales != null) {
                for (CampoAdicionalWS campoAdicionalWS : camposAdicionales) {
                    CampoAdicional ca = new CampoAdicional();
                    ca.setNombre(campoAdicionalWS.getNombre());
                    ca.setValue(campoAdicionalWS.getValue());
                    lstCamposAdicionales.add(ca);
                }
            }
            InfoAdicional ia = new InfoAdicional();
            ia.setCampoAdicional(lstCamposAdicionales);
            factura.setInfoAdicional(ia);
            factura.setId(facturaWS.getId());
            factura.setVersion(facturaWS.getVersion());
            resultado[0] = factura;
        } catch (Exception e) {
            resultado[0] = null;
            resultado[1] = ExceptionUtils.getStackTrace(e);
        }
        return resultado;
    }
}
