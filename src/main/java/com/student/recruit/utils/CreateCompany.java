package com.student.recruit.utils;

import com.minixiao.apiauth.client.HeaderUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by xiachao on 2017/3/29.
 */
public class CreateCompany {
  private RestTemplate restTemplate = new RestTemplate();

  /**
   * @Description 调接口创建公司 暂时用.
   * @Author xiachao
   * @CreateTime 2017/3/29 9:33
   * @Param
   * @Return
   */
  public void createCompany() {
    //要创建的公司实体
    RecruiterInfoDTO recruiterInfoDTO = new RecruiterInfoDTO();
    recruiterInfoDTO.setFullName("同程旅游有限公司-测试用");
    recruiterInfoDTO.setCity("上海");
    recruiterInfoDTO.setDescription("同程网络科技股份有限公司（简称同程旅游）是中国领先的休闲旅游在线服务商，创立于2004年，总部设在中国苏州，员工12000余人，注册资本20269万元。同程旅游的高速成长和创新的商业模式赢得了业界的广泛认可，2014年先后获得腾讯、携程等机构逾20亿元人民币投资。2015年7月，同程旅游再次获得万达、腾讯、中信资本等超过60亿元人民币的战略投资。\n" +
        "同程旅游是国家高新技术企业、商务部首批电子商务示范企业，“同程”商标荣获“中国驰名商标”，同程旅游连续四年入选“中国旅游集团20强”，2015年位列第8名，是中国在线旅游行业三大企业集团之一。新的十年，公司以“休闲旅游第一名”为战略目标，目前公司在中国景点门票预订市场和邮轮领域处于领先位置，并积极布局境外游、国内游、周边游等业务板块。\n" +
        "同程旅游旗下运营同程旅游网(www.LY.com)和同程旅游手机客户端， 2016年服务人次将达到3.5亿，年均增长300%，让更多人享受旅游的乐趣是同程旅游的使命。");
    recruiterInfoDTO.setDetailAddress("上海市高新区");
    recruiterInfoDTO.setLogo("http://www.mminixiao.com/st/images/42432432acb333ca.png");
    recruiterInfoDTO.setNature("中外合资企业");
    recruiterInfoDTO.setTags("五险一金，技能培训，年度旅游，带薪年假，节日礼物，岗位晋升，帅哥多，美女多，管理规范");
    recruiterInfoDTO.setPrimaryIndustry("生活服务-服务·咨询·外包");
    recruiterInfoDTO.setShortName("同城旅游");
    recruiterInfoDTO.setRecHref("http://www.minixiao.com/tongcehng");
    recruiterInfoDTO.setWebsite("http://www.ly.com");
    recruiterInfoDTO.setSlaveIndustry("计算机软件-互联网·游戏·软件");
    recruiterInfoDTO.setSize("2000-5000人");
    recruiterInfoDTO.setSlogan("非凡之路 快乐启程");
    LocalDate date1 = LocalDate.now();
    LocalDate date2 = LocalDate.now().plusYears(3);
    recruiterInfoDTO.setValidityStart(date1);
    recruiterInfoDTO.setValidityEnd(date2);
    recruiterInfoDTO.setSalesInfo("测试专用数据");
    recruiterInfoDTO.setScale("AAA");
    UUID userId = UUID.fromString("3ce67c6d-ec95-4642-b212-e1f7a4bced95");
    UUID recId = UUID.fromString("354bdb8f-ecd6-4c82-80fe-5f42db62d0a1");
    HttpHeaders httpHeaders = HeaderUtil.getHeader(userId, "夏超", "COMPANY",
        recId, "迷你校");
    httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
    HttpEntity<RecruiterInfoDTO> requestEntity = new HttpEntity(recruiterInfoDTO, httpHeaders);
    ResponseEntity<UUID> responseEntity = restTemplate.exchange(
        "http://127.0.0.1:9112/recruiters", HttpMethod.POST,
        requestEntity, UUID.class);
    if (responseEntity.getStatusCodeValue() == 201) {
      UUID recId2 = responseEntity.getBody();
      System.out.println("recId=" + recId2 + "公司创建成功");
      if (recId2 != null) {
        HttpEntity flowRequestEntity = new HttpEntity(null, httpHeaders);
        ResponseEntity<String> flowEntity = restTemplate.exchange("http://127.0.0.1:9112/recruiters/" + recId2 + "/flows/init", HttpMethod.POST, flowRequestEntity, String.class);
        if (flowEntity.getStatusCodeValue() == 200) {
          System.out.println("创建默认招聘流程成功");
          HttpEntity deptRequestEntity = new HttpEntity(null, httpHeaders);
          ResponseEntity<String> deptEntity = restTemplate.exchange("http://127.0.0.1:9112/recruiters/" + recId2 + "/department/init", HttpMethod.POST, deptRequestEntity, String.class);
          if (deptEntity.getStatusCodeValue() == 200) {
            System.out.println("创建公司一级部门成功");
          }
        }
      }

    }
  }

  public static void main(String[] args) {
    /*CreateCompany createCompany = new CreateCompany();
    createCompany.createCompany();*/
   /* String str = "生活服务-服务·咨询·外包";
    if (str.contains("-")) {
      System.out.println("啊哈哈");
    }*/
    //获取语言技能
    /*WebLanguage[] webLanguages = applicationWebDTO.getLanguage();
    if (webLanguages.length == 0) {
      Language[] languages = new Language[1];
      Language language = new Language();
      language.setLevel("");
      language.setType("");
      languages[0] = language;
      applicationDTO.setLanguage(languages);
    } else {
      Language[] languages = new Language[webLanguages.length];
      for (int i = 0; i < webLanguages.length; i++) {
        Language language = new Language();
        language.setLevel(webLanguages[i].getLevel());
        language.setType(webLanguages[i].getType());
        languages[i] = language;
      }
      applicationDTO.setLanguage(languages);
    }*/

  }
}
