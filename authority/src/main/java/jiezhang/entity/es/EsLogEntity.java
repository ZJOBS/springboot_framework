package jiezhang.entity.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "logentity")
public class EsLogEntity {
}
