package com.example.safeagile.Controllers;
import com.example.safeagile.Models.Demo;
import com.example.safeagile.Services.IServices.IDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/Demo")
@RequiredArgsConstructor
@CrossOrigin("*")
@Slf4j

public class DemoController  {
    private final IDemoService demoService ;
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    private static String UPLOAD_DIR = "uploads/";

//    @PostMapping
//    public ResponseEntity<?> addDemo(@RequestParam("introductionText") String introductionText,
//                                     @RequestParam("image1") MultipartFile image1,
//                                     @RequestParam("image2") MultipartFile image2) {
//        try {
//            Demo savedDemo = demoService.addDemo(introductionText, image1, image2);
//            return ResponseEntity.ok(savedDemo);
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing images: " + e.getMessage());
//        }
//    }
        @PostMapping
    public ResponseEntity<?> addDemo(  @RequestParam String S1_FS_Title,
                                       @RequestParam String S1_FS_Description,
                                       @RequestParam MultipartFile S1_FS_Image,
                                       @RequestParam String S1_SS_Introduction,
                                       @RequestParam MultipartFile S1_SS_Image,
                                       @RequestParam String S2_FS_Title,
                                       @RequestParam String S2_SS_Title,
                                       @RequestParam String S2_SS_Benefits1,
                                       @RequestParam String S2_SS_Benefits2,
                                       @RequestParam String S2_SS_Benefits3,
                                       @RequestParam String S2_SS_Benefits4,
                                       @RequestParam String S2_SS_Limitations1,
                                       @RequestParam String S2_SS_Limitations2,
                                       @RequestParam String S2_SS_Limitations3,
                                       @RequestParam String S2_SS_Limitations4,
                                       @RequestParam String S3_FS_Title,
                                       @RequestParam String S3_FS_Subtitle,
                                       @RequestParam String S3_FS_Description,
                                       @RequestParam MultipartFile S3_FS_Image,
                                       @RequestParam String S3_SS_Title,
                                       @RequestParam String S3_SS_Subtitle,
                                       @RequestParam MultipartFile S3_SS_Image,
                                       @RequestParam String S3_TS_Title,
                                       @RequestParam MultipartFile S3_TS_Image,
                                       @RequestParam String S3_TS_Ex_Text1,
                                       @RequestParam String S3_TS_Ex_Text2,
                                       @RequestParam String S3_TS_Ex_Text3,
                                       @RequestParam String S3_TS_Ex_Text4,
                                       @RequestParam String S3_FoS_Title,
                                       @RequestParam String S3_FoS_Subtitle,
                                       @RequestParam String S3_FoS_Text1,
                                       @RequestParam String S3_FoS_Text2,
                                       @RequestParam String S3_FoS_Text3,
                                       @RequestParam String S3_FoS_Text4,
                                       @RequestParam String S3_FoS_Text5,
                                       @RequestParam String S3_FoS_Text6,
                                       @RequestParam String S3_FoS_Text7,
                                       @RequestParam String S3_FoS_Text8,
                                       @RequestParam String S3_FoS_Text9,
                                       @RequestParam String S3_FoS_Text10,
                                       @RequestParam String S3_FiS_Title_center,
                                       @RequestParam String S3_FiS_Title1,
                                       @RequestParam String S3_FiS_Subtitle1,
                                       @RequestParam String S3_FiS_Title2,
                                       @RequestParam String S3_FiS_Subtitle2,
                                       @RequestParam String S3_FiS_Title3,
                                       @RequestParam String S3_FiS_Subtitle3,
                                       @RequestParam String S3_FiS_Title4,
                                       @RequestParam String S3_FiS_Subtitle4,
                                       @RequestParam String S3_SIS_Title_center,
                                       @RequestParam String S3_SIS_Title1,
                                       @RequestParam String S3_SIS_Subtitle1,
                                       @RequestParam String S3_SIS_Title2,
                                       @RequestParam String S3_SIS_Subtitle2,
                                       @RequestParam String S3_SIS_Title3,
                                       @RequestParam String S3_SIS_Subtitle3,
                                       @RequestParam String S3_SIS_Title4,
                                       @RequestParam String S3_SIS_Subtitle4,
                                       @RequestParam String S3_SIS_Title5,
                                       @RequestParam String S3_SIS_Subtitle5,
                                       @RequestParam String S3_SES_Title_center,
                                       @RequestParam String S3_SES_Title1,
                                       @RequestParam String S3_SES_Subtitle1,
                                       @RequestParam String S3_SES_Title2,
                                       @RequestParam String S3_SES_Subtitle2,
                                       @RequestParam String S3_SES_Title3,
                                       @RequestParam String S3_SES_Subtitle3,
                                       @RequestParam String S3_SES_Title4,
                                       @RequestParam String S3_SES_Subtitle4,
                                       @RequestParam String S4_FS_Title,
                                       @RequestParam String S4_FS_Subtitle,
                                       @RequestParam String S4_FS_Description,
                                       @RequestParam MultipartFile S4_FS_Image,
                                       @RequestParam String S4_SS_Description,
                                       @RequestParam MultipartFile S4_SS_Image,
                                       @RequestParam String S4_TS_Title,
                                       @RequestParam String S4_TS_Subtitle,
                                       @RequestParam MultipartFile S4_TS_Image,
                                       @RequestParam String S5_FS_Title,
                                       @RequestParam String S5_FS_Description,
                                       @RequestParam MultipartFile S5_FS_Image,
                                       @RequestParam String S5_SS_Title1,
                                       @RequestParam String S5_SS_Description1,
                                       @RequestParam MultipartFile S5_SS_Image1,
                                       @RequestParam String S5_SS_Title2,
                                       @RequestParam String S5_SS_Description2,
                                       @RequestParam MultipartFile S5_SS_Image2,
                                       @RequestParam String S5_SS_Title3,
                                       @RequestParam String S5_SS_Description3,
                                       @RequestParam MultipartFile S5_SS_Image3,
                                       @RequestParam String S5_SS_Title4,
                                       @RequestParam String S5_SS_Description4,
                                       @RequestParam MultipartFile S5_SS_Image4,
                                       @RequestParam String S5_SS_Title5,
                                       @RequestParam String S5_SS_Description5,
                                       @RequestParam MultipartFile S5_SS_Image5,
                                       @RequestParam String S5_SS_Title6,
                                       @RequestParam String S5_SS_Description6,
                                       @RequestParam MultipartFile S5_SS_Image6,
                                       @RequestParam String S6_Title,
                                       @RequestParam String S6_Subtitle,
                                       @RequestParam String S6_FS_Description_prob1,
                                       @RequestParam String S6_FS_Description6_solu1,
                                       @RequestParam String S6_SS_Description_prob2,
                                       @RequestParam String S6_SS_Description6_solu2,
                                       @RequestParam String S6_TS_Description_prob3,
                                       @RequestParam String S6_TS_Description6_solu3,
                                       @RequestParam String S6_FOS_Description_prob4,
                                       @RequestParam String S6_FOS_Description6_solu4,
                                       @RequestParam String Footer_Desc) {
        try {
            Demo savedDemo = demoService.addDemo(S1_FS_Title,      S1_FS_Description,
                    S1_FS_Image,
                    S1_SS_Introduction,
                    S1_SS_Image,
                    S2_FS_Title,
                    S2_SS_Title,
                    S2_SS_Benefits1,
                    S2_SS_Benefits2,
                    S2_SS_Benefits3,
                    S2_SS_Benefits4,
                    S2_SS_Limitations1,
                    S2_SS_Limitations2,
                    S2_SS_Limitations3,
                    S2_SS_Limitations4,
                    S3_FS_Title,
                    S3_FS_Subtitle,
                    S3_FS_Description,
                    S3_FS_Image,
                    S3_SS_Title,
                    S3_SS_Subtitle,
                    S3_SS_Image,
                    S3_TS_Title,
                    S3_TS_Image,
                    S3_TS_Ex_Text1,
                    S3_TS_Ex_Text2,
                    S3_TS_Ex_Text3,
                    S3_TS_Ex_Text4,
                    S3_FoS_Title,
                    S3_FoS_Subtitle,
                    S3_FoS_Text1,
                    S3_FoS_Text2,
                    S3_FoS_Text3,
                    S3_FoS_Text4,
                    S3_FoS_Text5,
                    S3_FoS_Text6,
                    S3_FoS_Text7,
                    S3_FoS_Text8,
                    S3_FoS_Text9,
                    S3_FoS_Text10,
                    S3_FiS_Title_center,
                    S3_FiS_Title1,
                    S3_FiS_Subtitle1,
                    S3_FiS_Title2,
                    S3_FiS_Subtitle2,
                    S3_FiS_Title3,
                    S3_FiS_Subtitle3,
                    S3_FiS_Title4,
                    S3_FiS_Subtitle4,
                    S3_SIS_Title_center,
                    S3_SIS_Title1,
                    S3_SIS_Subtitle1,
                    S3_SIS_Title2,
                    S3_SIS_Subtitle2,
                    S3_SIS_Title3,
                    S3_SIS_Subtitle3,
                    S3_SIS_Title4,
                    S3_SIS_Subtitle4,
                    S3_SIS_Title5,
                    S3_SIS_Subtitle5,
                    S3_SES_Title_center,
                    S3_SES_Title1,
                    S3_SES_Subtitle1,
                    S3_SES_Title2,
                    S3_SES_Subtitle2,
                    S3_SES_Title3,
                    S3_SES_Subtitle3,
                    S3_SES_Title4,
                    S3_SES_Subtitle4,
                    S4_FS_Title,
                    S4_FS_Subtitle,
                    S4_FS_Description,
                    S4_FS_Image,
                    S4_SS_Description,
                    S4_SS_Image,
                    S4_TS_Title,
                    S4_TS_Subtitle,
                    S4_TS_Image,
                    S5_FS_Title,
                    S5_FS_Description,
                    S5_FS_Image,
                    S5_SS_Title1,
                    S5_SS_Description1,
                    S5_SS_Image1,
                    S5_SS_Title2,
                    S5_SS_Description2,
                    S5_SS_Image2,
                    S5_SS_Title3,
                    S5_SS_Description3,
                    S5_SS_Image3,
                    S5_SS_Title4,
                    S5_SS_Description4,
                    S5_SS_Image4,
                    S5_SS_Title5,
                    S5_SS_Description5,
                    S5_SS_Image5,
                    S5_SS_Title6,
                    S5_SS_Description6,
                    S5_SS_Image6,
                    S6_Title,
                    S6_Subtitle,
                    S6_FS_Description_prob1,
                    S6_FS_Description6_solu1,
                    S6_SS_Description_prob2,
                    S6_SS_Description6_solu2,
                    S6_TS_Description_prob3,
                    S6_TS_Description6_solu3,
                    S6_FOS_Description_prob4,
                    S6_FOS_Description6_solu4,
                    Footer_Desc );
            return ResponseEntity.ok(savedDemo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing images: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<Demo> getById(@PathVariable String id) {
        return demoService.getById(id);
    }


    // Endpoint to update a Demo entity
    @PutMapping("/{id}")
    public ResponseEntity<Demo> updateDemo(@PathVariable("id") String id, @RequestBody Demo updatedDemo) {
        try {
            logger.debug("Received request to update Demo with ID: {}", id);

            // Set the ID of updatedDemo from path variable
            updatedDemo.set_id(id);

            // Call service layer method to update the Demo
            Demo savedDemo = demoService.updateDemo(updatedDemo);

            // Return the updated Demo object in the response
            return ResponseEntity.ok(savedDemo);
        } catch (IllegalArgumentException ex) {
            // Log the error
            logger.error("Error updating Demo with ID: {}", id, ex);
            // Return 404 Not Found if Demo with given ID does not exist
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            // Log the error
            logger.error("Error updating Demo with ID: {}", id, ex);
            // Return 500 Internal Server Error for other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
