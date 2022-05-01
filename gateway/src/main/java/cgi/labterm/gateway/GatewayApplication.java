package cgi.labterm.gateway;

import cgi.labterm.lib.npu.NpuService;
import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GatewayApplication {


	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Value("${labterm.npu.host:localhost}")
	private String host;

	@Value("${labterm.npu.port:8000}")
	private String port;

	@Value("${labterm.npu.protocol:http}")
	private String protocol;

	@Bean
	public NpuService getNpuService() {
		return new NpuService(host, port);
	}

	@Bean
	public String getServiceurl() { return protocol + "://" + host + ":" + port + "/npu"; }

	@Bean
	public JaegerTracer jaegerTracer() {
		return new io.jaegertracing.Configuration("labterm-gateway")
				.withSampler(new io.jaegertracing.Configuration.SamplerConfiguration().withType(ConstSampler.TYPE)
						.withParam(1))
				.withReporter(new io.jaegertracing.Configuration.ReporterConfiguration().withLogSpans(true))
				.getTracer();
	}
	@Bean
	public RestTemplate restTemplate(
			RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

}
