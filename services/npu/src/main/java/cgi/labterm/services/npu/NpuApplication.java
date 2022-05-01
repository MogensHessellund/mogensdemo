package cgi.labterm.services.npu;

import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class NpuApplication {

	public static void main(String[] args) {
		SpringApplication.run(NpuApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(
			RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

	@Bean
	public JaegerTracer jaegerTracer() {
		return new io.jaegertracing.Configuration("labterm-npu")
				.withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE)
						.withParam(1))
				.withReporter(new io.jaegertracing.Configuration.ReporterConfiguration().withLogSpans(true))
				.getTracer();
	}
}
