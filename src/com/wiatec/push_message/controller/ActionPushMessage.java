package com.wiatec.push_message.controller;

import com.wiatec.push_message.entities.PushMessageInfo;
import com.wiatec.push_message.service.PushMessageService;
import com.wiatec.push_message.utils.FileUtil;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.util.List;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Controller
public class ActionPushMessage extends BaseAction {

    private int id;
    private List<PushMessageInfo> pushMessageInfoList;
    private PushMessageInfo pushMessageInfo;
    private List<File> file;
    private List<String> fileFileName;
    private List<String> fileContentType;
    private String uploadStatus;
    private String imagePath = "http://www.ldlegacy.com:8899/static/ldfam/image/";
    @Autowired
    private PushMessageService pushMessageService;

    public void get(){
        pushMessageInfoList = pushMessageService.getAll();
        out.println(JSONArray.fromObject(pushMessageInfoList));
        out.flush();
        out.close();
    }

    public void getAd(){
        pushMessageInfoList = pushMessageService.getPushMessageByUserName("wiatecpush");
        out.println(JSONArray.fromObject(pushMessageInfoList));
        out.flush();
        out.close();
    }

    public String show(){
        checkSession();
        pushMessageInfoList = pushMessageService.getPushMessageByUserName(userName);
        return "show";
    }

    public String edit(){
        checkSession();
        if(id >0){
            pushMessageInfo = pushMessageService.getPushMessageById(id);
        }
        return "edit";
    }

    public String upload(){
        checkSession();
        if(file != null && file.size() >0){
            if(id ==0){
                pushMessageInfo = new PushMessageInfo();
            }else{
                pushMessageInfo = pushMessageService.getPushMessageById(id);
            }
            for(int i =0; i< file.size() ; i++){
                File f = file.get(i);
                String fileName = fileFileName.get(i);
                if(FileUtil.upload(f , fileName)){
                    if(i == 0) {
                        pushMessageInfo.setImg1(imagePath + fileName);
                    }else if(i == 1){
                        pushMessageInfo.setImg2(imagePath + fileName);
                    }
                    uploadStatus = "upload success";
                }else {
                    uploadStatus = "upload failure";
                }
            }
        }
        return "upload";
    }

    public String update(){
        checkSession();
        if(id > 0){
            pushMessageInfo.setId(id);
            pushMessageInfo.setUserName(userName);
            pushMessageService.update(pushMessageInfo);
        }else{
            pushMessageInfo.setUserName(userName);
            pushMessageService.insert(pushMessageInfo);
        }
        return "update";
    }

    public String delete(){
        checkSession();
        pushMessageService.delete(id);
        return "delete";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PushMessageInfo> getPushMessageInfoList() {
        return pushMessageInfoList;
    }

    public void setPushMessageInfoList(List<PushMessageInfo> pushMessageInfoList) {
        this.pushMessageInfoList = pushMessageInfoList;
    }

    public PushMessageInfo getPushMessageInfo() {
        return pushMessageInfo;
    }

    public void setPushMessageInfo(PushMessageInfo pushMessageInfo) {
        this.pushMessageInfo = pushMessageInfo;
    }

    public List<File> getFile() {
        return file;
    }

    public void setFile(List<File> file) {
        this.file = file;
    }

    public List<String> getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(List<String> fileFileName) {
        this.fileFileName = fileFileName;
    }

    public List<String> getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(List<String> fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getUploadStatus() {
        return uploadStatus;
    }

    public void setUploadStatus(String uploadStatus) {
        this.uploadStatus = uploadStatus;
    }
}
