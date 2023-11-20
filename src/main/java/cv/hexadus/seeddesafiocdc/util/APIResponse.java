package cv.hexadus.seeddesafiocdc.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.List;

public class APIResponse {

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();
    private boolean status;
    private String statusText;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Object> details;

    private APIResponse(Builder builder) {
        status = builder.status;
        statusText = builder.statusText;
        details = builder.details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public String getStatusText() {
        return statusText;
    }

    public List<Object> getDetails() {
        return details;
    }

    public static final class Builder {
        private boolean status;
        private String statusText;
        private List<Object> details;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder status(boolean val) {
            status = val;
            return this;
        }

        public Builder statusText(String val) {
            statusText = val;
            return this;
        }

        public Builder details(List<Object> val) {
            details = val;
            return this;
        }

        public APIResponse build() {
            return new APIResponse(this);
        }
    }
}
