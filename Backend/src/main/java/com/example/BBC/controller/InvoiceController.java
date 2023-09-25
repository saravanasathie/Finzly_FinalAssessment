package com.example.BBC.controller;

package com.finzly.UtilityBill_PaymentPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finzly.UtilityBill_PaymentPlatform.entity.CustomerBillData;
import com.finzly.UtilityBill_PaymentPlatform.entity.InvoiceInfo;
import com.finzly.UtilityBill_PaymentPlatform.service.InvoiceInfoService;

@CrossOrigin()
@RestController
@RequestMapping("invoice")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceInfoService;
	
	
	@PostMapping("/addInvoiceInfo")
	public void addInvoiceInfo(@RequestBody InvoiceInfo invoiceinfo ) {
		invoiceInfoService.addInvoiceInfo(invoiceinfo);
	}
	
	@GetMapping("/getInvoiceInfo/{billId}")
	public InvoiceInfo getInvoiceInfo(@PathVariable int billId) {
		return invoiceInfoService.getInvoiceInfo(billId);
	}
	
	
	

}