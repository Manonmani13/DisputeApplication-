package com.business.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.business.app.modl.Dispute;
import com.business.app.modl.DisputeEvent;
import com.business.app.modl.Refund;
import com.business.app.service.DisputeService;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/disputes")
public class DisputeController {
	
	@Autowired
	private DisputeService service;
	
	
	@PostMapping
	@ResponseBody
	public String save(Model model,@RequestBody Dispute requst) {
        model.addAttribute("dispute",service.saveDispute(requst));
		return "dispute";
	}
	
	@GetMapping
	@ResponseBody
	public List<Dispute> getDisputes(@RequestParam String custId, @RequestParam String status ){
		return service.searchDisputes(custId,status);
	}
	
	@GetMapping("/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        model.addAttribute("dispute", service.findOne(id));
        return "DisputeDetail";
    }
	
	@PostMapping("{id}/refund")
	@ResponseBody
	public Refund saveRefund(@PathParam("id") Long id, @RequestBody Refund requst) {
		return service.saveRefund(id,requst);
	}
	
	@PostMapping("{id}/decision")
	@ResponseBody
	public String saveDisputeEvent(Model model,@PathParam("id") Long id, @RequestBody DisputeEvent requst) {
		model.addAttribute("decison",service.saveDisputeEvent(id,requst));
		return "disputeList";
	}
	

}
