package cgi.labterm.lib.npu;

import cgi.labterm.lib.gateway.model.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@Log4j2
public class NpuService {

	@Autowired
	private RestTemplate restTemplate;

	@SuppressWarnings({ "FieldCanBeLocal", "unused" }) // Intellij støj
	private final String host;
	@SuppressWarnings({ "FieldCanBeLocal", "unused" })
	private final String port;

	private final String url;

	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	public NpuService(String host, String port) {
		this.host = host;
		this.port = port;
		@SuppressWarnings("HttpUrlsUsage")
		String url = "http://" + host + ":" + port;
		this.url = url;
		log.info(String.format("NpuService url : %s", url));

	}

	@Deprecated
	public OrganisationModel getOrganisation(String navn) {
		return restTemplate.getForObject(url + "/npu/organisation?navn=" + navn, OrganisationModel.class);
	}

	@Deprecated
	public OrganisationModel getOrganisation(long id) {
		return restTemplate.getForObject(url + "/npu/organisation?id=" + id, OrganisationModel.class);
	}

	@Deprecated
	public List<OrganisationModel> getOrganisations(QueryModel[] queryModels, int limit, int offset, String sortColumn,
			String order) {
		ResponseEntity<OrganisationModel[]> response = restTemplate.postForEntity(url + "/npu/organisationer/?limit="
				+ limit + "&offset=" + offset + "&sortcolumn=" + sortColumn + "&order=" + order, queryModels,
				OrganisationModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	@Deprecated
	public List<OrganisationModel> getOrganisationsForReleasecenter(String rc) {
		ResponseEntity<OrganisationModel[]> response = restTemplate
				.getForEntity(url + "/npu/organisation/releasecenter/?rc=" + rc, OrganisationModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	@Deprecated
	public void createOrganisation(OrganisationModel org) {
		restTemplate.put(url + "/npu/organisation/new", org);
	}

	@Deprecated
	public void importOrganisation(OrganisationModel org) {
		restTemplate.postForObject(url + "/npu/organisation/import", org, OrganisationModel.class);
	}

	@Deprecated
	public OrganisationModel changestatusOrganisation(OrganisationModel org) {
		HttpEntity<OrganisationModel> request = new HttpEntity<>(org);
		ResponseEntity<OrganisationModel> ret = restTemplate.postForEntity(url + "/npu/organisation/changestatus",
				request, OrganisationModel.class);
		return ret.getBody();
	}

	@Deprecated
	public OrganisationModel updateOrganisation(OrganisationModel org) {
		HttpEntity<OrganisationModel> request = new HttpEntity<>(org);
		ResponseEntity<OrganisationModel> ret = restTemplate.postForEntity(url + "/npu/organisation/update", request,
				OrganisationModel.class);
		return ret.getBody();
	}

	@Deprecated
	public List<OrganisationModel> getRevisionsForOrganisation(long id) {
		ResponseEntity<OrganisationModel[]> response = restTemplate
				.getForEntity(url + "/npu/organisation/revisions/?id=" + id, OrganisationModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	@Deprecated
	public Long getOrganisationsCount(QueryModel[] queryModels) {
		ResponseEntity<Long> response = restTemplate.postForEntity(url + "/npu/organisationer/count", queryModels,
				Long.class);
		return response.getBody();
	}

	@Deprecated
	public List<NoteModel> lookupNotesForElement(long id) {
		ResponseEntity<NoteModel[]> response = restTemplate
				.getForEntity(url + "/npu/organisation/noterforelement?id=" + id, NoteModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	@Deprecated
	public NoteModel addNote(NoteModel note) {
		HttpEntity<NoteModel> request = new HttpEntity<>(note);
		ResponseEntity<NoteModel> ret = restTemplate.postForEntity(url + "/npu/organisation/newnote", request,
				NoteModel.class);
		return ret.getBody();
	}

	@Deprecated
	public void deleteNoteForOrganisation(long id) {
		HttpEntity<Long> request = new HttpEntity<>(id);
		restTemplate.postForEntity(url + "/npu/organisation/note/delete", request, Void.class);
	}

	@Deprecated
	public NoteModel updateNoteForOrganisation(NoteModel note) {
		HttpEntity<NoteModel> request = new HttpEntity<>(note);
		ResponseEntity<NoteModel> ret = restTemplate.postForEntity(url + "/npu/organisation/note/update", request,
				NoteModel.class);
		return ret.getBody();

	}

	@Deprecated
	public List<OrganisationModel> makeOrganisationCopies(Long id, Integer number) {
		ResponseEntity<OrganisationModel[]> response = restTemplate.getForEntity(
				url + "/npu/organisation/copies?id=" + id + "&number=" + number, OrganisationModel[].class);

		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public List<NpubegrebModel> makeCopies(long id, int number) {
		ResponseEntity<NpubegrebModel[]> response = restTemplate.postForEntity(
				url + "/npu/npubegreb/copies?id=" + id + "&number=" + number, null, NpubegrebModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public NpubegrebModel getNpubegreb(long id) {
		return restTemplate.getForObject(url + "/npu/npubegreb?id=" + id, NpubegrebModel.class);
	}

	public NpubegrebModel getNpubegreb(String kode) {
		return restTemplate.getForObject(url + "/npu/npubegreb/npukode?npukode=" + kode, NpubegrebModel.class);
	}

	public void createNpubegreb(NpubegrebModel org) {
		restTemplate.put(url + "/npu/npubegreb/new", org);
	}

	public List<NpubegrebModel> getRevisionsForNpubegreb(long id) {
		ResponseEntity<NpubegrebModel[]> response = restTemplate
				.getForEntity(url + "/npu/npubegreb/revisions/?id=" + id, NpubegrebModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public void deleteNoteForNpubegreb(long id) {
		HttpEntity<Long> request = new HttpEntity<>(id);
		restTemplate.postForEntity(url + "/npu/npubegreb/note/delete", request, Void.class);
	}

	public ElementbegrebModel getElementbegreb(long id) {
		return restTemplate.getForObject(url + "/npu/elementbegreb?id=" + id, ElementbegrebModel.class);
	}

	public List<ElementbegrebModel> getElementbegreber(QueryModel[] queryModels, int limit, int offset,
			String sortColumn, String order) {
		ResponseEntity<ElementbegrebModel[]> response = restTemplate.postForEntity(url + "/npu/elementbegreber/?limit="
				+ limit + "&offset=" + offset + "&sortcolumn=" + sortColumn + "&order=" + order, queryModels,
				ElementbegrebModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public List<ElementbegrebModel> makeElementbegrebCopies(Long id, Integer number) {
		ResponseEntity<ElementbegrebModel[]> response = restTemplate.getForEntity(
				url + "/npu/elementbegreber/copies?id=" + id + "&number=" + number, ElementbegrebModel[].class);

		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public List<ElementbegrebModel> getElementbegreberForReleasecenter(String rc) {
		ResponseEntity<ElementbegrebModel[]> response = restTemplate
				.getForEntity(url + "/npu/elementbegreb/releasecenter/?rc=" + rc, ElementbegrebModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public void createElementbegreb(ElementbegrebModel org) {
		restTemplate.put(url + "/npu/elementbegreb/new", org);
	}

	public ElementbegrebModel changestatusElementbegreb(ElementbegrebModel org) {
		HttpEntity<ElementbegrebModel> request = new HttpEntity<>(org);
		ResponseEntity<ElementbegrebModel> ret = restTemplate.postForEntity(url + "/npu/elementbegreb/changestatus",
				request, ElementbegrebModel.class);
		return ret.getBody();
	}

	public ElementbegrebModel updateElementbegreb(ElementbegrebModel org) {
		HttpEntity<ElementbegrebModel> request = new HttpEntity<>(org);
		ResponseEntity<ElementbegrebModel> ret = restTemplate.postForEntity(url + "/npu/elementbegreb/update", request,
				ElementbegrebModel.class);
		return ret.getBody();
	}

	public List<ElementbegrebModel> getRevisionsElementbegreb(long id) {
		ResponseEntity<ElementbegrebModel[]> response = restTemplate
				.getForEntity(url + "/npu/elementbegreb/revisions/?id=" + id, ElementbegrebModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public Long getElementbegreberCount(QueryModel[] queryModels) {
		ResponseEntity<Long> response = restTemplate.postForEntity(url + "/npu/elementbegreber/count", queryModels,
				Long.class);
		return response.getBody();
	}

	public List<NoteModel> lookupNotesForElementbegreb(long id) {
		ResponseEntity<NoteModel[]> response = restTemplate
				.getForEntity(url + "/npu/elementbegreb/noterforelement?id=" + id, NoteModel[].class);
		return Arrays.asList(Objects.requireNonNull(response.getBody()));
	}

	public NoteModel addNoteElementbegreb(NoteModel note) {
		HttpEntity<NoteModel> request = new HttpEntity<>(note);
		ResponseEntity<NoteModel> ret = restTemplate.postForEntity(url + "/npu/elementbegreb/newnote", request,
				NoteModel.class);
		return ret.getBody();
	}

	public void deleteNoteForElementbegreb(long id) {
		HttpEntity<Long> request = new HttpEntity<>(id);
		restTemplate.postForEntity(url + "/npu/elementbegreb/note/delete", request, Void.class);
	}

	public NoteModel updateNoteForElementbegreb(NoteModel note) {
		HttpEntity<NoteModel> request = new HttpEntity<>(note);
		ResponseEntity<NoteModel> ret = restTemplate.postForEntity(url + "/npu/elementbegreb/note/update", request,
				NoteModel.class);
		return ret.getBody();

	}

}
