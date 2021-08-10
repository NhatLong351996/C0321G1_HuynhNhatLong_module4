package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.dto.ContractDto;
import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Contract;
import com.codegym.model.entity.ContractDetail;
import com.codegym.model.service.contract_detail_service.IAttachService;
import com.codegym.model.service.contract_detail_service.IContractDetailService;
import com.codegym.model.service.contract_service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;
    @Autowired
    private IAttachService attachService;
    @ModelAttribute("listContract")
    public List<Contract> getListContract(){
        return contractService.findAll();
    }
    @ModelAttribute("listAttachService")
    public List<AttachService> getListAttachService(){
        return attachService.findAll();
    }
    @GetMapping
    public ModelAndView getFormCreate(){
        return new ModelAndView("/contract_detail/create",
                "contractDetailDto",new ContractDetailDto());
    }
    @PostMapping
    public ModelAndView create(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                               BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/create");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("contractDetailDto", contractDetailDto);
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            contractDetailService.save(contractDetail);
            modelAndView.addObject("contractDetailDto", new ContractDetailDto());
            modelAndView.addObject("message",
                    "Contract Detail have been created!");
        }
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView getFormListContract(@PageableDefault(value = 5) Pageable pageable,
                                            @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("contract_detail/list");
        Page<ContractDetail> contractDetails;
        if (search.isPresent()) {
            contractDetails = contractDetailService.findByAttachService_NameAttachService(search.get(), pageable);
        } else {
            contractDetails = contractDetailService.findAll(pageable);
        }
        modelAndView.addObject("contractDetails", contractDetails);
        modelAndView.addObject("search", search.orElse(null));
        return modelAndView;
    }

}
