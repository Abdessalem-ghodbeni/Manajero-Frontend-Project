package com.example.safeagile.Models;

import lombok.*;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Demo")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Demo {
    @Id
    private String _id;
    //First_Step
    //First_section
    private String S1_FS_Title;
    private String S1_FS_Description;
    private Binary S1_FS_Image;
    //Second_section
    private String S1_SS_Introduction;
    private Binary S1_SS_Image;

    //Second_Step
    //First_Section
    private String S2_FS_Title;
    //Second_Section
    private String S2_SS_Title;
    private String S2_SS_Benefits1;
    private String S2_SS_Benefits2;
    private String S2_SS_Benefits3;
    private String S2_SS_Benefits4;
    private String S2_SS_Limitations1;
    private String S2_SS_Limitations2;
    private String S2_SS_Limitations3;
    private String S2_SS_Limitations4;

    //Third_Step
    //First_Section
    private String S3_FS_Title;
    private String S3_FS_Subtitle;
    private String S3_FS_Description;
    private Binary S3_FS_Image;
    //Second_Section
    private String S3_SS_Title;
    private String S3_SS_Subtitle;
    private Binary S3_SS_Image;
    //Third_Section
    private String S3_TS_Title;
    private Binary S3_TS_Image;
    private String S3_TS_Ex_Text1;
    private String S3_TS_Ex_Text2;
    private String S3_TS_Ex_Text3;
    private String S3_TS_Ex_Text4;
    //Fourth_Section
    private String S3_FoS_Title;
    private String S3_FoS_Subtitle;
    private String S3_FoS_Text1;
    private String S3_FoS_Text2;
    private String S3_FoS_Text3;
    private String S3_FoS_Text4;
    private String S3_FoS_Text5;
    private String S3_FoS_Text6;
    private String S3_FoS_Text7;
    private String S3_FoS_Text8;
    private String S3_FoS_Text9;
    private String S3_FoS_Text10;
    //fifth_section
    private String S3_FiS_Title_center;
    private String S3_FiS_Title1;
    private String S3_FiS_Subtitle1;
    private String S3_FiS_Title2;
    private String S3_FiS_Subtitle2;
    private String S3_FiS_Title3;
    private String S3_FiS_Subtitle3;
    private String S3_FiS_Title4;
    private String S3_FiS_Subtitle4;
    //sixth_section
    private String S3_SIS_Title_center;
    private String S3_SIS_Title1;
    private String S3_SIS_Subtitle1;
    private String S3_SIS_Title2;
    private String S3_SIS_Subtitle2;
    private String S3_SIS_Title3;
    private String S3_SIS_Subtitle3;
    private String S3_SIS_Title4;
    private String S3_SIS_Subtitle4;
    private String S3_SIS_Title5;
    private String S3_SIS_Subtitle5;
    //Seventh_section
    private String S3_SES_Title_center;
    private String S3_SES_Title1;
    private String S3_SES_Subtitle1;
    private String S3_SES_Title2;
    private String S3_SES_Subtitle2;
    private String S3_SES_Title3;
    private String S3_SES_Subtitle3;
    private String S3_SES_Title4;
    private String S3_SES_Subtitle4;

    //Fourth_step
    //First_section
    private String S4_FS_Title;
    private String S4_FS_Subtitle;
    private String S4_FS_Description;
    private Binary S4_FS_Image;
    //Second_section
    private String S4_SS_Description;
    private Binary S4_SS_Image;
    //Third_section
    private String S4_TS_Title;
    private String S4_TS_Subtitle;
    private Binary S4_TS_Image;

    //Fifth_step
    //First_section
    private String S5_FS_Title;
    private String S5_FS_Description;
    private Binary S5_FS_Image;
    //Second_section
    private String S5_SS_Title1;
    private String S5_SS_Description1;
    private Binary S5_SS_Image1;
    //Second_section
    private String S5_SS_Title2;
    private String S5_SS_Description2;
    private Binary S5_SS_Image2;
    //Second_section
    private String S5_SS_Title3;
    private String S5_SS_Description3;
    private Binary S5_SS_Image3;
    //Second_section
    private String S5_SS_Title4;
    private String S5_SS_Description4;
    private Binary S5_SS_Image4;
    //Second_section
    private String S5_SS_Title5;
    private String S5_SS_Description5;
    private Binary S5_SS_Image5;
    //Second_section
    private String S5_SS_Title6;
    private String S5_SS_Description6;
    private Binary S5_SS_Image6;


    //sixth_step
    private String S6_Title;
    private String S6_Subtitle;
    //First_section
    private String S6_FS_Description_prob1;
    private String S6_FS_Description6_solu1;
    //Second_section
    private String S6_SS_Description_prob2;
    private String S6_SS_Description6_solu2;
    //Third_section
    private String S6_TS_Description_prob3;
    private String S6_TS_Description6_solu3;
    //Fourth_section
    private String S6_FOS_Description_prob4;
    private String S6_FOS_Description6_solu4;

    //Footer
    private String Footer_Desc;

}
