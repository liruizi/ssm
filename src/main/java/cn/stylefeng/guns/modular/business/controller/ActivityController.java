//package cn.stylefeng.guns.modular.business.controller;
//
//import javax.annotation.Resource;
//
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.stylefeng.guns.modular.business.pojo.ActivityParam;
//import cn.stylefeng.guns.modular.business.service.ActivityService;
//import cn.stylefeng.roses.kernel.rule.pojo.response.ResponseData;
//import cn.stylefeng.roses.kernel.rule.pojo.response.SuccessResponseData;
///**
// * tb_activity 控制器
// *
// * @author: fengshuonan
// * @date: 2021/03/22 14:07
// */
//@RestController
//public class ActivityController {
//
//    @Resource
//    private ActivityService activityService;
//
//    /**
//     * 分页查询tb_activity
//     *
//     * @author fengshuonan
//     * @date 2021/03/22 14:07
//     */
//    @GetMapping("/activity/page")
//    public ResponseData page(ActivityParam activityParam) {
//        return new SuccessResponseData(activityService.page(activityParam));
//    }
//
//    /**
//     * 获取全部tb_activity
//     *
//     * @author fengshuonan
//     * @date 2021/03/22 14:07
//     */
//    @GetMapping("/activity/list")
//    @BusinessLog(title = "tb_activity_查询所有", opType = LogAnnotionOpTypeEnum.QUERY)
//    public ResponseData list(ActivityParam activityParam) {
//        return new SuccessResponseData(activityService.list(activityParam));
//    }
//
//    /**
//     * 查看详情tb_activity
//     *
//     * @author fengshuonan
//     * @date 2021/03/22 14:07
//     */
//    @GetMapping("/activity/detail")
//    public ResponseData detail(@Validated(ActivityParam.detail.class) ActivityParam activityParam) {
//        return new SuccessResponseData(activityService.detail(activityParam));
//    }
//
//    /**
//     * 添加tb_activity
//     *
//     * @author fengshuonan
//     * @date 2021/03/22 14:07
//     */
//    @PostMapping("/activity/add")
//    public ResponseData add(@RequestBody @Validated(ActivityParam.add.class) ActivityParam activityParam) {
//        activityService.add(activityParam);
//        return new SuccessResponseData();
//    }
//
//    /**
//     * 删除tb_activity
//     *
//     * @author fengshuonan
//     * @date 2021/03/22 14:07
//     */
//    @PostMapping("/activity/delete")
//    public ResponseData delete(@RequestBody @Validated(ActivityParam.delete.class) ActivityParam activityParam) {
//        activityService.delete(activityParam);
//        return new SuccessResponseData();
//    }
//
//    /**
//     * 编辑tb_activity
//     *
//     * @author fengshuonan
//     * @date 2021/03/22 14:07
//     */
//    @PostMapping("/activity/edit")
//    public ResponseData edit(@RequestBody @Validated(ActivityParam.edit.class) ActivityParam activityParam) {
//        activityService.edit(activityParam);
//        return new SuccessResponseData();
//    }
//
//
//}
