package com.nicascript.notificationpayments.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicascript.notificationpayments.dto.entity.PaymentEntity;
import com.nicascript.notificationpayments.dto.request.PaymentReportDto;
import com.nicascript.notificationpayments.repository.PaymentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentServices  {
  private final PaymentRepository paymentRepository;
  private final JavaMailSender mailSender;

  ObjectMapper mapper = new ObjectMapper();

  @Autowired
  public PaymentServices(PaymentRepository paymentRepository, JavaMailSender mailSender) {
    this.paymentRepository = paymentRepository;
    this.mailSender = mailSender;
  }

  public List<PaymentEntity> getAllPayment() {
    return paymentRepository.findAll();
  }

  public PaymentEntity createPayment(PaymentEntity paymentEntity) {
    return paymentRepository.save(paymentEntity);
  }

  public PaymentEntity paymentByUuid(UUID uuid) {
    var paymentUuid = paymentRepository.findById(uuid);
    if (paymentUuid.isPresent()) {
      return paymentUuid.get();
    } else {
      throw new EntityNotFoundException("No se encontro el Uuid");
    }
  }

  public List<PaymentReportDto> getPaymentCategoryDetails() throws JsonProcessingException {

    var result = paymentRepository.findPaymentCategoryDetails();
    sendNewMail(
        "matthewreyesvanegas46@gmail.com", "hola prueba importante", formatPaymentReport(result));
    return result;
  }

  public void sendNewMail(String to, String subject, String body) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setTo(to);
    message.setSubject(subject);
    message.setText(body);
    mailSender.send(message);
  }

  public String formatPaymentReport(List<PaymentReportDto> paymentReports) {
    StringBuilder reportBuilder = new StringBuilder();
//
//    // Encabezado del HTML
//    reportBuilder.append("<html>");
//    reportBuilder.append("<head><style>");
//    reportBuilder.append("table { width: 100%; border-collapse: collapse; }");
//    reportBuilder.append("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
//    reportBuilder.append("th { background-color: #f2f2f2; }");
//    reportBuilder.append("</style></head>");
//    reportBuilder.append("<body>");
//
//    // Título del reporte
//    reportBuilder.append("<h2>Payment Report</h2>");
//
//    // Tabla del reporte
//    reportBuilder.append("<table>");
//    reportBuilder.append("<tr>");
//    reportBuilder.append("<th>Payment Name</th>");
//    reportBuilder.append("<th>Amount</th>");
//    reportBuilder.append("<th>Category</th>");
//    reportBuilder.append("</tr>");
//
//    // Filas de la tabla
//    for (PaymentReportDto report : paymentReports) {
//      reportBuilder.append("<tr>");
//      reportBuilder.append("<td>").append(report.getPaymentName()).append("</td>");
//      reportBuilder
//          .append("<td>")
//          .append(String.format("%.2f", report.getAmount()))
//          .append("</td>");
//      reportBuilder.append("<td>").append(report.getCategoryName()).append("</td>");
//      reportBuilder.append("</tr>");
//    }
//
//    // Pie de página del reporte
//    reportBuilder.append("</table>");
//    reportBuilder.append("<p>Total Payments: ").append(paymentReports.size()).append("</p>");
//
//    // Cierre del HTML
//    reportBuilder.append("</body>");
//    reportBuilder.append("</html>");

    return reportBuilder.toString();
  }
}
