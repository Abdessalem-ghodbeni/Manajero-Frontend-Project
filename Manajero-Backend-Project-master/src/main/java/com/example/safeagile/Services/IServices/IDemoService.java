package com.example.safeagile.Services.IServices;

import com.example.safeagile.Models.Demo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IDemoService {

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
    ) throws IOException;

    Demo updateDemo(Demo updatedDemo);

    public Optional<Demo> getById(String id);
}
