package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.entity.AttachService;
import com.codegym.model.entity.Contract;
import com.codegym.model.entity.ContractDetail;
import com.codegym.dto.IContractDetailDto;
import com.codegym.model.entity.Customer;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public List<Contract> getListContract() {
        return contractService.findAll();
    }

    @ModelAttribute("listAttachService")
    public List<AttachService> getListAttachService() {
        return attachService.findAll();
    }

    @GetMapping
    public ModelAndView getFormCreate() {
        return new ModelAndView("/contract_detail/create",
                "contractDetailDto", new ContractDetailDto());
    }

    @PostMapping
    public ModelAndView create(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                               BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/contract_detail/create");
        if (bindingResult.hasFieldErrors()) {
            modelAndView.addObject("contractDetailDto", contractDetailDto);
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            modelAndView.addObject("contractDetailDto", new ContractDetailDto());
            modelAndView.addObject("message",
                    "Contract Detail have been created!");
        }
        return modelAndView;
    }
    /*@PostMapping("/create")
    public String save(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                       BindingResult bindingResult, Model model,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("contractDetailDto", contractDetailDto);
            return "/contractDetail/create";
        } else {
            Contract contract = contractService.findByContractId(contractDetailDto.getContract()
                    .getContractId());
            Double newTotalMoney = contract.getContractTotalMoney() +
                    contractDetailDto.getQuantity()*contractDetailDto.getAttachService()
                            .getAttachServiceCost();
            contract.setContractTotalMoney(newTotalMoney);
            String listAttachService = "";
            if(contract.getListAttachService().isEmpty()){
                listAttachService = contractDetailDto.getAttachService().
                        getAttachServiceName() +"-Quantity: " +contractDetailDto.getQuantity();
            }
            else {
                listAttachService = contract.getListAttachService()  +" , "
                        + contractDetailDto.getAttachService().getAttachServiceName()
                        +"-Quantity: " +contractDetailDto.getQuantity();
            }
            contract.setListAttachService(listAttachService);
            contractDetailDto.setFlag(1);
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            contractDetailService.save(contractDetail);
            redirectAttributes.addFlashAttribute("message",
                    "New Contract Detail created successfully");
            return "redirect:/contractDetail";
        }
    }*/

    @GetMapping("/list")
    public ModelAndView getFormListContract(@PageableDefault(value = 5) Pageable pageable,
                                            @RequestParam Optional<String> search) {
        ModelAndView modelAndView = new ModelAndView("contract_detail/list");
        Page<IContractDetailDto> contractDetails;
        if (!search.isPresent()) {
            contractDetails = contractDetailService.listFindAll(pageable);
        } else {
            contractDetails = contractDetailService.listFindByNameAttach(pageable, search.get());
        }
        modelAndView.addObject("contractDetails", contractDetails);
        modelAndView.addObject("search", search.orElse(null));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getFormEdit(@PathVariable Long id) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        BeanUtils.copyProperties(contractDetail,contractDetailDto);
        return new ModelAndView("contract_detail/edit","contractDetailDto",contractDetailDto);
    }
    @PostMapping("/edit")
    public ModelAndView edit(@Valid @ModelAttribute ContractDetailDto contractDetailDto,
                             BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("contract_detail/edit");
        if (bindingResult.hasFieldErrors()){
            modelAndView.addObject("contractDetailDto",contractDetailDto);
        }else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto,contractDetail);
            contractDetailService.save(contractDetail);
            modelAndView.addObject("contractDetailDto",contractDetailDto);
            modelAndView.addObject("message","Update Success!");
        }
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id,
                               RedirectAttributes redirectAttributes) {
        ContractDetail contractDetail = contractDetailService.findById(id);
        contractDetailService.delete(contractDetail);
        redirectAttributes.addFlashAttribute("message","delete success!");
        return new ModelAndView("redirect:/contractDetail/list");
    }

    @GetMapping("/view/{id}")
    public ModelAndView getView(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("contract_detail/view");
        ContractDetail contractDetail = contractDetailService.findById(id);
        modelAndView.addObject("contractDetail", contractDetail);
        modelAndView.addObject("message", "INFORMATION");
        return modelAndView;
    }

}
