import { Notification, Message } from "element-ui";

const Notifys = {
  error(error) {
    Notification.error({
      title: "错误",
      message: error,
    });
  },
  message(message) {
    Notification({
      title: "成功",
      message,
      type: "success",
    });
  },
};

const Messages = {
  success(message) {
    Message({
      message,
      type: "success",
    });
  },
  error(error) {
    Message.error(error);
  },
};
export { Notifys, Messages };
