package com.example.safeagile.Services.ServicesImp;

import com.example.safeagile.Models.Demo;
import com.example.safeagile.Repositories.IDemoRepository;
import com.example.safeagile.Services.IServices.IDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoServiceImpementation implements IDemoService {
    private final IDemoRepository demoRepository;

    public Demo addDemo(
            String S1_FS_Title, String S1_FS_Description, MultipartFile S1_FS_Image,
            String S1_SS_Introduction, MultipartFile S1_SS_Image,
            String S2_FS_Title,
            String S2_SS_Title, String S2_SS_Benefits1, String S2_SS_Benefits2, String S2_SS_Benefits3, String S2_SS_Benefits4,
            String S2_SS_Limitations1, String S2_SS_Limitations2, String S2_SS_Limitations3, String S2_SS_Limitations4,
            String S3_FS_Title, String S3_FS_Subtitle, String S3_FS_Description, MultipartFile S3_FS_Image,
            String S3_SS_Title, String S3_SS_Subtitle, MultipartFile S3_SS_Image,
            String S3_TS_Title, MultipartFile S3_TS_Image, String S3_TS_Ex_Text1, String S3_TS_Ex_Text2, String S3_TS_Ex_Text3, String S3_TS_Ex_Text4,
            String S3_FoS_Title, String S3_FoS_Subtitle, String S3_FoS_Text1, String S3_FoS_Text2, String S3_FoS_Text3, String S3_FoS_Text4,
            String S3_FoS_Text5, String S3_FoS_Text6, String S3_FoS_Text7, String S3_FoS_Text8, String S3_FoS_Text9, String S3_FoS_Text10,
            String S3_FiS_Title_center, String S3_FiS_Title1, String S3_FiS_Subtitle1, String S3_FiS_Title2, String S3_FiS_Subtitle2,
            String S3_FiS_Title3, String S3_FiS_Subtitle3, String S3_FiS_Title4, String S3_FiS_Subtitle4,
            String S3_SIS_Title_center, String S3_SIS_Title1, String S3_SIS_Subtitle1, String S3_SIS_Title2, String S3_SIS_Subtitle2,
            String S3_SIS_Title3, String S3_SIS_Subtitle3, String S3_SIS_Title4, String S3_SIS_Subtitle4, String S3_SIS_Title5, String S3_SIS_Subtitle5,
            String S3_SES_Title_center, String S3_SES_Title1, String S3_SES_Subtitle1, String S3_SES_Title2, String S3_SES_Subtitle2,
            String S3_SES_Title3, String S3_SES_Subtitle3, String S3_SES_Title4, String S3_SES_Subtitle4,
            String S4_FS_Title, String S4_FS_Subtitle, String S4_FS_Description, MultipartFile S4_FS_Image,
            String S4_SS_Description, MultipartFile S4_SS_Image, String S4_TS_Title, String S4_TS_Subtitle, MultipartFile S4_TS_Image,
            String S5_FS_Title, String S5_FS_Description, MultipartFile S5_FS_Image, String S5_SS_Title1, String S5_SS_Description1, MultipartFile S5_SS_Image1,
            String S5_SS_Title2, String S5_SS_Description2, MultipartFile S5_SS_Image2, String S5_SS_Title3, String S5_SS_Description3, MultipartFile S5_SS_Image3,
            String S5_SS_Title4, String S5_SS_Description4, MultipartFile S5_SS_Image4, String S5_SS_Title5, String S5_SS_Description5, MultipartFile S5_SS_Image5,
            String S5_SS_Title6, String S5_SS_Description6, MultipartFile S5_SS_Image6,
            String S6_Title, String S6_Subtitle, String S6_FS_Description_prob1, String S6_FS_Description6_solu1,
            String S6_SS_Description_prob2, String S6_SS_Description6_solu2, String S6_TS_Description_prob3, String S6_TS_Description6_solu3,
            String S6_FOS_Description_prob4, String S6_FOS_Description6_solu4, String Footer_Desc
    ) throws IOException {
        Demo demo = new Demo();

        // First Step
        demo.setS1_FS_Title(S1_FS_Title);
        demo.setS1_FS_Description(S1_FS_Description);
        demo.setS1_FS_Image(new Binary(S1_FS_Image.getBytes()));
        demo.setS1_SS_Introduction(S1_SS_Introduction);
        demo.setS1_SS_Image(new Binary(S1_SS_Image.getBytes()));

        // Second Step
        demo.setS2_FS_Title(S2_FS_Title);
        demo.setS2_SS_Title(S2_SS_Title);
        demo.setS2_SS_Benefits1(S2_SS_Benefits1);
        demo.setS2_SS_Benefits2(S2_SS_Benefits2);
        demo.setS2_SS_Benefits3(S2_SS_Benefits3);
        demo.setS2_SS_Benefits4(S2_SS_Benefits4);
        demo.setS2_SS_Limitations1(S2_SS_Limitations1);
        demo.setS2_SS_Limitations2(S2_SS_Limitations2);
        demo.setS2_SS_Limitations3(S2_SS_Limitations3);
        demo.setS2_SS_Limitations4(S2_SS_Limitations4);

        // Third Step
        demo.setS3_FS_Title(S3_FS_Title);
        demo.setS3_FS_Subtitle(S3_FS_Subtitle);
        demo.setS3_FS_Description(S3_FS_Description);
        demo.setS3_FS_Image(new Binary(S3_FS_Image.getBytes()));
        demo.setS3_SS_Title(S3_SS_Title);
        demo.setS3_SS_Subtitle(S3_SS_Subtitle);
        demo.setS3_SS_Image(new Binary(S3_SS_Image.getBytes()));
        demo.setS3_TS_Title(S3_TS_Title);
        demo.setS3_TS_Image(new Binary(S3_TS_Image.getBytes()));
        demo.setS3_TS_Ex_Text1(S3_TS_Ex_Text1);
        demo.setS3_TS_Ex_Text2(S3_TS_Ex_Text2);
        demo.setS3_TS_Ex_Text3(S3_TS_Ex_Text3);
        demo.setS3_TS_Ex_Text4(S3_TS_Ex_Text4);
        demo.setS3_FoS_Title(S3_FoS_Title);
        demo.setS3_FoS_Subtitle(S3_FoS_Subtitle);
        demo.setS3_FoS_Text1(S3_FoS_Text1);
        demo.setS3_FoS_Text2(S3_FoS_Text2);
        demo.setS3_FoS_Text3(S3_FoS_Text3);
        demo.setS3_FoS_Text4(S3_FoS_Text4);
        demo.setS3_FoS_Text5(S3_FoS_Text5);
        demo.setS3_FoS_Text6(S3_FoS_Text6);
        demo.setS3_FoS_Text7(S3_FoS_Text7);
        demo.setS3_FoS_Text8(S3_FoS_Text8);
        demo.setS3_FoS_Text9(S3_FoS_Text9);
        demo.setS3_FoS_Text10(S3_FoS_Text10);
        demo.setS3_FiS_Title_center(S3_FiS_Title_center);
        demo.setS3_FiS_Title1(S3_FiS_Title1);
        demo.setS3_FiS_Subtitle1(S3_FiS_Subtitle1);
        demo.setS3_FiS_Title2(S3_FiS_Title2);
        demo.setS3_FiS_Subtitle2(S3_FiS_Subtitle2);
        demo.setS3_FiS_Title3(S3_FiS_Title3);
        demo.setS3_FiS_Subtitle3(S3_FiS_Subtitle3);
        demo.setS3_FiS_Title4(S3_FiS_Title4);
        demo.setS3_FiS_Subtitle4(S3_FiS_Subtitle4);
        demo.setS3_SIS_Title_center(S3_SIS_Title_center);
        demo.setS3_SIS_Title1(S3_SIS_Title1);
        demo.setS3_SIS_Subtitle1(S3_SIS_Subtitle1);
        demo.setS3_SIS_Title2(S3_SIS_Title2);
        demo.setS3_SIS_Subtitle2(S3_SIS_Subtitle2);
        demo.setS3_SIS_Title3(S3_SIS_Title3);
        demo.setS3_SIS_Subtitle3(S3_SIS_Subtitle3);
        demo.setS3_SIS_Title4(S3_SIS_Title4);
        demo.setS3_SIS_Subtitle4(S3_SIS_Subtitle4);
        demo.setS3_SIS_Title5(S3_SIS_Title5);
        demo.setS3_SIS_Subtitle5(S3_SIS_Subtitle5);
        demo.setS3_SES_Title_center(S3_SES_Title_center);
        demo.setS3_SES_Title1(S3_SES_Title1);
        demo.setS3_SES_Subtitle1(S3_SES_Subtitle1);
        demo.setS3_SES_Title2(S3_SES_Title2);
        demo.setS3_SES_Subtitle2(S3_SES_Subtitle2);
        demo.setS3_SES_Title3(S3_SES_Title3);
        demo.setS3_SES_Subtitle3(S3_SES_Subtitle3);
        demo.setS3_SES_Title4(S3_SES_Title4);
        demo.setS3_SES_Subtitle4(S3_SES_Subtitle4);

        // Fourth Step
        demo.setS4_FS_Title(S4_FS_Title);
        demo.setS4_FS_Subtitle(S4_FS_Subtitle);
        demo.setS4_FS_Description(S4_FS_Description);
        demo.setS4_FS_Image(new Binary(S4_FS_Image.getBytes()));
        demo.setS4_SS_Description(S4_SS_Description);
        demo.setS4_SS_Image(new Binary(S4_SS_Image.getBytes()));
        demo.setS4_TS_Title(S4_TS_Title);
        demo.setS4_TS_Subtitle(S4_TS_Subtitle);
        demo.setS4_TS_Image(new Binary(S4_TS_Image.getBytes()));

        // Fifth Step
        demo.setS5_FS_Title(S5_FS_Title);
        demo.setS5_FS_Description(S5_FS_Description);
        demo.setS5_FS_Image(new Binary(S5_FS_Image.getBytes()));
        demo.setS5_SS_Title1(S5_SS_Title1);
        demo.setS5_SS_Description1(S5_SS_Description1);
        demo.setS5_SS_Image1(new Binary(S5_SS_Image1.getBytes()));
        demo.setS5_SS_Title2(S5_SS_Title2);
        demo.setS5_SS_Description2(S5_SS_Description2);
        demo.setS5_SS_Image2(new Binary(S5_SS_Image2.getBytes()));
        demo.setS5_SS_Title3(S5_SS_Title3);
        demo.setS5_SS_Description3(S5_SS_Description3);
        demo.setS5_SS_Image3(new Binary(S5_SS_Image3.getBytes()));
        demo.setS5_SS_Title4(S5_SS_Title4);
        demo.setS5_SS_Description4(S5_SS_Description4);
        demo.setS5_SS_Image4(new Binary(S5_SS_Image4.getBytes()));
        demo.setS5_SS_Title5(S5_SS_Title5);
        demo.setS5_SS_Description5(S5_SS_Description5);
        demo.setS5_SS_Image5(new Binary(S5_SS_Image5.getBytes()));
        demo.setS5_SS_Title6(S5_SS_Title6);
        demo.setS5_SS_Description6(S5_SS_Description6);
        demo.setS5_SS_Image6(new Binary(S5_SS_Image6.getBytes()));

        // Sixth Step
        demo.setS6_Title(S6_Title);
        demo.setS6_Subtitle(S6_Subtitle);
        demo.setS6_FS_Description_prob1(S6_FS_Description_prob1);
        demo.setS6_FS_Description6_solu1(S6_FS_Description6_solu1);
        demo.setS6_SS_Description_prob2(S6_SS_Description_prob2);
        demo.setS6_SS_Description6_solu2(S6_SS_Description6_solu2);
        demo.setS6_TS_Description_prob3(S6_TS_Description_prob3);
        demo.setS6_TS_Description6_solu3(S6_TS_Description6_solu3);
        demo.setS6_FOS_Description_prob4(S6_FOS_Description_prob4);
        demo.setS6_FOS_Description6_solu4(S6_FOS_Description6_solu4);

        // Footer
        demo.setFooter_Desc(Footer_Desc);
        return demoRepository.save(demo);
    }



    private Binary uploadImage(MultipartFile file) throws IOException {
    return new Binary(file.getBytes());
}



    @Override
    public Demo updateDemo(Demo updatedDemo) {
        // Check if the demo exists in the database
        Demo existingDemo = demoRepository.findById(updatedDemo.get_id())
                .orElseThrow(() -> new IllegalArgumentException("Demo not found: " + updatedDemo.get_id()));

        // Log the received and existing demo objects for debugging
        log.debug("Received Demo object: {}", updatedDemo);
        log.debug("Existing Demo object before update: {}", existingDemo);

        // Update only non-null fields from updatedDemo

        // First Step - First Section
        if (updatedDemo.getS1_FS_Title() != null) {
            existingDemo.setS1_FS_Title(updatedDemo.getS1_FS_Title());
        }
        if (updatedDemo.getS1_FS_Description() != null) {
            existingDemo.setS1_FS_Description(updatedDemo.getS1_FS_Description());
        }
        if (updatedDemo.getS1_FS_Image() != null) {
            existingDemo.setS1_FS_Image(updatedDemo.getS1_FS_Image());
        }

        // First Step - Second Section
        if (updatedDemo.getS1_SS_Introduction() != null) {
            existingDemo.setS1_SS_Introduction(updatedDemo.getS1_SS_Introduction());
        }
        if (updatedDemo.getS1_SS_Image() != null) {
            existingDemo.setS1_SS_Image(updatedDemo.getS1_SS_Image());
        }

        // Second Step - First Section
        if (updatedDemo.getS2_FS_Title() != null) {
            existingDemo.setS2_FS_Title(updatedDemo.getS2_FS_Title());
        }

        // Second Step - Second Section
        if (updatedDemo.getS2_SS_Title() != null) {
            existingDemo.setS2_SS_Title(updatedDemo.getS2_SS_Title());
        }
        if (updatedDemo.getS2_SS_Benefits1() != null) {
            existingDemo.setS2_SS_Benefits1(updatedDemo.getS2_SS_Benefits1());
        }
        if (updatedDemo.getS2_SS_Benefits2() != null) {
            existingDemo.setS2_SS_Benefits2(updatedDemo.getS2_SS_Benefits2());
        }
        if (updatedDemo.getS2_SS_Benefits3() != null) {
            existingDemo.setS2_SS_Benefits3(updatedDemo.getS2_SS_Benefits3());
        }
        if (updatedDemo.getS2_SS_Benefits4() != null) {
            existingDemo.setS2_SS_Benefits4(updatedDemo.getS2_SS_Benefits4());
        }
        if (updatedDemo.getS2_SS_Limitations1() != null) {
            existingDemo.setS2_SS_Limitations1(updatedDemo.getS2_SS_Limitations1());
        }
        if (updatedDemo.getS2_SS_Limitations2() != null) {
            existingDemo.setS2_SS_Limitations2(updatedDemo.getS2_SS_Limitations2());
        }
        if (updatedDemo.getS2_SS_Limitations3() != null) {
            existingDemo.setS2_SS_Limitations3(updatedDemo.getS2_SS_Limitations3());
        }
        if (updatedDemo.getS2_SS_Limitations4() != null) {
            existingDemo.setS2_SS_Limitations4(updatedDemo.getS2_SS_Limitations4());
        }

        // Third Step - First Section
        if (updatedDemo.getS3_FS_Title() != null) {
            existingDemo.setS3_FS_Title(updatedDemo.getS3_FS_Title());
        }
        if (updatedDemo.getS3_FS_Subtitle() != null) {
            existingDemo.setS3_FS_Subtitle(updatedDemo.getS3_FS_Subtitle());
        }
        if (updatedDemo.getS3_FS_Description() != null) {
            existingDemo.setS3_FS_Description(updatedDemo.getS3_FS_Description());
        }
        if (updatedDemo.getS3_FS_Image() != null) {
            existingDemo.setS3_FS_Image(updatedDemo.getS3_FS_Image());
        }

        // Third Step - Second Section
        if (updatedDemo.getS3_SS_Title() != null) {
            existingDemo.setS3_SS_Title(updatedDemo.getS3_SS_Title());
        }
        if (updatedDemo.getS3_SS_Subtitle() != null) {
            existingDemo.setS3_SS_Subtitle(updatedDemo.getS3_SS_Subtitle());
        }
        if (updatedDemo.getS3_SS_Image() != null) {
            existingDemo.setS3_SS_Image(updatedDemo.getS3_SS_Image());
        }

        // Third Step - Third Section
        if (updatedDemo.getS3_TS_Title() != null) {
            existingDemo.setS3_TS_Title(updatedDemo.getS3_TS_Title());
        }
        if (updatedDemo.getS3_TS_Image() != null) {
            existingDemo.setS3_TS_Image(updatedDemo.getS3_TS_Image());
        }
        if (updatedDemo.getS3_TS_Ex_Text1() != null) {
            existingDemo.setS3_TS_Ex_Text1(updatedDemo.getS3_TS_Ex_Text1());
        }
        if (updatedDemo.getS3_TS_Ex_Text2() != null) {
            existingDemo.setS3_TS_Ex_Text2(updatedDemo.getS3_TS_Ex_Text2());
        }
        if (updatedDemo.getS3_TS_Ex_Text3() != null) {
            existingDemo.setS3_TS_Ex_Text3(updatedDemo.getS3_TS_Ex_Text3());
        }
        if (updatedDemo.getS3_TS_Ex_Text4() != null) {
            existingDemo.setS3_TS_Ex_Text4(updatedDemo.getS3_TS_Ex_Text4());
        }

        // Third Step - Fourth Section
        if (updatedDemo.getS3_FoS_Title() != null) {
            existingDemo.setS3_FoS_Title(updatedDemo.getS3_FoS_Title());
        }
        if (updatedDemo.getS3_FoS_Subtitle() != null) {
            existingDemo.setS3_FoS_Subtitle(updatedDemo.getS3_FoS_Subtitle());
        }
        if (updatedDemo.getS3_FoS_Text1() != null) {
            existingDemo.setS3_FoS_Text1(updatedDemo.getS3_FoS_Text1());
        }
        if (updatedDemo.getS3_FoS_Text2() != null) {
            existingDemo.setS3_FoS_Text2(updatedDemo.getS3_FoS_Text2());
        }
        if (updatedDemo.getS3_FoS_Text3() != null) {
            existingDemo.setS3_FoS_Text3(updatedDemo.getS3_FoS_Text3());
        }
        if (updatedDemo.getS3_FoS_Text4() != null) {
            existingDemo.setS3_FoS_Text4(updatedDemo.getS3_FoS_Text4());
        }
        if (updatedDemo.getS3_FoS_Text5() != null) {
            existingDemo.setS3_FoS_Text5(updatedDemo.getS3_FoS_Text5());
        }
        if (updatedDemo.getS3_FoS_Text6() != null) {
            existingDemo.setS3_FoS_Text6(updatedDemo.getS3_FoS_Text6());
        }
        if (updatedDemo.getS3_FoS_Text7() != null) {
            existingDemo.setS3_FoS_Text7(updatedDemo.getS3_FoS_Text7());
        }
        if (updatedDemo.getS3_FoS_Text8() != null) {
            existingDemo.setS3_FoS_Text8(updatedDemo.getS3_FoS_Text8());
        }
        if (updatedDemo.getS3_FoS_Text9() != null) {
            existingDemo.setS3_FoS_Text9(updatedDemo.getS3_FoS_Text9());
        }
        if (updatedDemo.getS3_FoS_Text10() != null) {
            existingDemo.setS3_FoS_Text10(updatedDemo.getS3_FoS_Text10());
        }

        // Third Step - Fifth Section
        if (updatedDemo.getS3_FiS_Title_center() != null) {
            existingDemo.setS3_FiS_Title_center(updatedDemo.getS3_FiS_Title_center());
        }
        if (updatedDemo.getS3_FiS_Title1() != null) {
            existingDemo.setS3_FiS_Title1(updatedDemo.getS3_FiS_Title1());
        }
        if (updatedDemo.getS3_FiS_Subtitle1() != null) {
            existingDemo.setS3_FiS_Subtitle1(updatedDemo.getS3_FiS_Subtitle1());
        }
        if (updatedDemo.getS3_FiS_Title2() != null) {
            existingDemo.setS3_FiS_Title2(updatedDemo.getS3_FiS_Title2());
        }
        if (updatedDemo.getS3_FiS_Subtitle2() != null) {
            existingDemo.setS3_FiS_Subtitle2(updatedDemo.getS3_FiS_Subtitle2());
        }
        if (updatedDemo.getS3_FiS_Title3() != null) {
            existingDemo.setS3_FiS_Title3(updatedDemo.getS3_FiS_Title3());
        }
        if (updatedDemo.getS3_FiS_Subtitle3() != null) {
            existingDemo.setS3_FiS_Subtitle3(updatedDemo.getS3_FiS_Subtitle3());
        }
        if (updatedDemo.getS3_FiS_Title4() != null) {
            existingDemo.setS3_FiS_Title4(updatedDemo.getS3_FiS_Title4());
        }
        if (updatedDemo.getS3_FiS_Subtitle4() != null) {
            existingDemo.setS3_FiS_Subtitle4(updatedDemo.getS3_FiS_Subtitle4());
        }

        // Third Step - Sixth Section
        if (updatedDemo.getS3_SIS_Title_center() != null) {
            existingDemo.setS3_SIS_Title_center(updatedDemo.getS3_SIS_Title_center());
        }
        if (updatedDemo.getS3_SIS_Title1() != null) {
            existingDemo.setS3_SIS_Title1(updatedDemo.getS3_SIS_Title1());
        }
        if (updatedDemo.getS3_SIS_Subtitle1() != null) {
            existingDemo.setS3_SIS_Subtitle1(updatedDemo.getS3_SIS_Subtitle1());
        }
        if (updatedDemo.getS3_SIS_Title2() != null) {
            existingDemo.setS3_SIS_Title2(updatedDemo.getS3_SIS_Title2());
        }
        if (updatedDemo.getS3_SIS_Subtitle2() != null) {
            existingDemo.setS3_SIS_Subtitle2(updatedDemo.getS3_SIS_Subtitle2());
        }
        if (updatedDemo.getS3_SIS_Title3() != null) {
            existingDemo.setS3_SIS_Title3(updatedDemo.getS3_SIS_Title3());
        }
        if (updatedDemo.getS3_SIS_Subtitle3() != null) {
            existingDemo.setS3_SIS_Subtitle3(updatedDemo.getS3_SIS_Subtitle3());
        }
        if (updatedDemo.getS3_SIS_Title4() != null) {
            existingDemo.setS3_SIS_Title4(updatedDemo.getS3_SIS_Title4());
        }
        if (updatedDemo.getS3_SIS_Subtitle4() != null) {
            existingDemo.setS3_SIS_Subtitle4(updatedDemo.getS3_SIS_Subtitle4());
        }
        if (updatedDemo.getS3_SIS_Title5() != null) {
            existingDemo.setS3_SIS_Title5(updatedDemo.getS3_SIS_Title5());
        }
        if (updatedDemo.getS3_SIS_Subtitle5() != null) {
            existingDemo.setS3_SIS_Subtitle5(updatedDemo.getS3_SIS_Subtitle5());
        }

        // Third Step - Seventh Section
        if (updatedDemo.getS3_SES_Title_center() != null) {
            existingDemo.setS3_SES_Title_center(updatedDemo.getS3_SES_Title_center());
        }
        if (updatedDemo.getS3_SES_Title1() != null) {
            existingDemo.setS3_SES_Title1(updatedDemo.getS3_SES_Title1());
        }
        if (updatedDemo.getS3_SES_Subtitle1() != null) {
            existingDemo.setS3_SES_Subtitle1(updatedDemo.getS3_SES_Subtitle1());
        }
        if (updatedDemo.getS3_SES_Title2() != null) {
            existingDemo.setS3_SES_Title2(updatedDemo.getS3_SES_Title2());
        }
        if (updatedDemo.getS3_SES_Subtitle2() != null) {
            existingDemo.setS3_SES_Subtitle2(updatedDemo.getS3_SES_Subtitle2());
        }
        if (updatedDemo.getS3_SES_Title3() != null) {
            existingDemo.setS3_SES_Title3(updatedDemo.getS3_SES_Title3());
        }
        if (updatedDemo.getS3_SES_Subtitle3() != null) {
            existingDemo.setS3_SES_Subtitle3(updatedDemo.getS3_SES_Subtitle3());
        }
        if (updatedDemo.getS3_SES_Title4() != null) {
            existingDemo.setS3_SES_Title4(updatedDemo.getS3_SES_Title4());
        }
        if (updatedDemo.getS3_SES_Subtitle4() != null) {
            existingDemo.setS3_SES_Subtitle4(updatedDemo.getS3_SES_Subtitle4());
        }

        // Fourth Step - First Section
        if (updatedDemo.getS4_FS_Title() != null) {
            existingDemo.setS4_FS_Title(updatedDemo.getS4_FS_Title());
        }
        if (updatedDemo.getS4_FS_Subtitle() != null) {
            existingDemo.setS4_FS_Subtitle(updatedDemo.getS4_FS_Subtitle());
        }
        if (updatedDemo.getS4_FS_Description() != null) {
            existingDemo.setS4_FS_Description(updatedDemo.getS4_FS_Description());
        }
        if (updatedDemo.getS4_FS_Image() != null) {
            existingDemo.setS4_FS_Image(updatedDemo.getS4_FS_Image());
        }

        // Fourth Step - Second Section
        if (updatedDemo.getS4_SS_Description() != null) {
            existingDemo.setS4_SS_Description(updatedDemo.getS4_SS_Description());
        }
        if (updatedDemo.getS4_SS_Image() != null) {
            existingDemo.setS4_SS_Image(updatedDemo.getS4_SS_Image());
        }

        // Fourth Step - Third Section
        if (updatedDemo.getS4_TS_Title() != null) {
            existingDemo.setS4_TS_Title(updatedDemo.getS4_TS_Title());
        }
        if (updatedDemo.getS4_TS_Subtitle() != null) {
            existingDemo.setS4_TS_Subtitle(updatedDemo.getS4_TS_Subtitle());
        }
        if (updatedDemo.getS4_TS_Image() != null) {
            existingDemo.setS4_TS_Image(updatedDemo.getS4_TS_Image());
        }

        // Fifth Step - First Section
        if (updatedDemo.getS5_FS_Title() != null) {
            existingDemo.setS5_FS_Title(updatedDemo.getS5_FS_Title());
        }
        if (updatedDemo.getS5_FS_Description() != null) {
            existingDemo.setS5_FS_Description(updatedDemo.getS5_FS_Description());
        }
        if (updatedDemo.getS5_FS_Image() != null) {
            existingDemo.setS5_FS_Image(updatedDemo.getS5_FS_Image());
        }

        // Fifth Step - Second Section (Multiple)
        if (updatedDemo.getS5_SS_Title1() != null) {
            existingDemo.setS5_SS_Title1(updatedDemo.getS5_SS_Title1());
        }
        if (updatedDemo.getS5_SS_Description1() != null) {
            existingDemo.setS5_SS_Description1(updatedDemo.getS5_SS_Description1());
        }
        if (updatedDemo.getS5_SS_Image1() != null) {
            existingDemo.setS5_SS_Image1(updatedDemo.getS5_SS_Image1());
        }
        if (updatedDemo.getS5_SS_Title2() != null) {
            existingDemo.setS5_SS_Title2(updatedDemo.getS5_SS_Title2());
        }
        if (updatedDemo.getS5_SS_Description2() != null) {
            existingDemo.setS5_SS_Description2(updatedDemo.getS5_SS_Description2());
        }
        if (updatedDemo.getS5_SS_Image2() != null) {
            existingDemo.setS5_SS_Image2(updatedDemo.getS5_SS_Image2());
        }
        if (updatedDemo.getS5_SS_Title3() != null) {
            existingDemo.setS5_SS_Title3(updatedDemo.getS5_SS_Title3());
        }
        if (updatedDemo.getS5_SS_Description3() != null) {
            existingDemo.setS5_SS_Description3(updatedDemo.getS5_SS_Description3());
        }
        if (updatedDemo.getS5_SS_Image3() != null) {
            existingDemo.setS5_SS_Image3(updatedDemo.getS5_SS_Image3());
        }
        if (updatedDemo.getS5_SS_Title4() != null) {
            existingDemo.setS5_SS_Title4(updatedDemo.getS5_SS_Title4());
        }
        if (updatedDemo.getS5_SS_Description4() != null) {
            existingDemo.setS5_SS_Description4(updatedDemo.getS5_SS_Description4());
        }
        if (updatedDemo.getS5_SS_Image4() != null) {
            existingDemo.setS5_SS_Image4(updatedDemo.getS5_SS_Image4());
        }
        if (updatedDemo.getS5_SS_Title5() != null) {
            existingDemo.setS5_SS_Title5(updatedDemo.getS5_SS_Title5());
        }
        if (updatedDemo.getS5_SS_Description5() != null) {
            existingDemo.setS5_SS_Description5(updatedDemo.getS5_SS_Description5());
        }
        if (updatedDemo.getS5_SS_Image5() != null) {
            existingDemo.setS5_SS_Image5(updatedDemo.getS5_SS_Image5());
        }
        if (updatedDemo.getS5_SS_Title6() != null) {
            existingDemo.setS5_SS_Title6(updatedDemo.getS5_SS_Title6());
        }
        if (updatedDemo.getS5_SS_Description6() != null) {
            existingDemo.setS5_SS_Description6(updatedDemo.getS5_SS_Description6());
        }
        if (updatedDemo.getS5_SS_Image6() != null) {
            existingDemo.setS5_SS_Image6(updatedDemo.getS5_SS_Image6());
        }

        // Sixth Step
        if (updatedDemo.getS6_Title() != null) {
            existingDemo.setS6_Title(updatedDemo.getS6_Title());
        }
        if (updatedDemo.getS6_Subtitle() != null) {
            existingDemo.setS6_Subtitle(updatedDemo.getS6_Subtitle());
        }
        if (updatedDemo.getS6_FS_Description_prob1() != null) {
            existingDemo.setS6_FS_Description_prob1(updatedDemo.getS6_FS_Description_prob1());
        }
        if (updatedDemo.getS6_FS_Description6_solu1() != null) {
            existingDemo.setS6_FS_Description6_solu1(updatedDemo.getS6_FS_Description6_solu1());
        }
        if (updatedDemo.getS6_SS_Description_prob2() != null) {
            existingDemo.setS6_SS_Description_prob2(updatedDemo.getS6_SS_Description_prob2());
        }
        if (updatedDemo.getS6_SS_Description6_solu2() != null) {
            existingDemo.setS6_SS_Description6_solu2(updatedDemo.getS6_SS_Description6_solu2());
        }
        if (updatedDemo.getS6_TS_Description_prob3() != null) {
            existingDemo.setS6_TS_Description_prob3(updatedDemo.getS6_TS_Description_prob3());
        }
        if (updatedDemo.getS6_TS_Description6_solu3() != null) {
            existingDemo.setS6_TS_Description6_solu3(updatedDemo.getS6_TS_Description6_solu3());
        }
        if (updatedDemo.getS6_FOS_Description_prob4() != null) {
            existingDemo.setS6_FOS_Description_prob4(updatedDemo.getS6_FOS_Description_prob4());
        }
        if (updatedDemo.getS6_FOS_Description6_solu4() != null) {
            existingDemo.setS6_FOS_Description6_solu4(updatedDemo.getS6_FOS_Description6_solu4());
        }

        // Footer
        if (updatedDemo.getFooter_Desc() != null) {
            existingDemo.setFooter_Desc(updatedDemo.getFooter_Desc());
        }

        // Save the updated demo object in the database
        Demo savedDemo = demoRepository.save(existingDemo);

        // Log the updated demo object for debugging
        log.debug("Updated Demo object: {}", savedDemo);

        return savedDemo;
    }


    public Optional<Demo> getById(String id) {
        return demoRepository.findById(id);
    }





}
