package org.unicarbkb.rdf;

import com.hp.hpl.jena.rdf.model.*;


public class bibo {
    /**
     * <p>The RDF model that holds the vocabulary terms</p>
     */
    private static Model m_model = ModelFactory.createDefaultModel();

    /**
     * <p>The namespace of the vocabulary as a string</p>
     */
    public static final String NS = "http://purl.org/ontology/bibo/";

    /**
     * <p>The namespace of the vocabulary as a string</p>
     *
     * @see #NS
     */
    public static String getURI() {
        return NS;
    }

    /**
     * <p>The namespace of the vocabulary as a resource</p>
     */
    public static final Resource NAMESPACE = m_model.createResource(NS);

    /**
     * <p>A scholarly academic article, typically published in a journal.</p>
     */
    public static final Resource AcademicArticle = m_model.createResource("http://purl.org/ontology/bibo/AcademicArticle");

    /**
     * <p>A written composition in prose, usually nonfiction, on a specific topic, forming
     * an independent part of a book or other publication, as a newspaper or magazine.</p>
     */
    public static final Resource Article = m_model.createResource("http://purl.org/ontology/bibo/Article");

    /**
     * <p>An audio document; aka record.</p>
     */
    public static final Resource AudioDocument = m_model.createResource("http://purl.org/ontology/bibo/AudioDocument");

    /**
     * <p>An audio-visual document; film, video, and so forth.</p>
     */
    public static final Resource AudioVisualDocument = m_model.createResource("http://purl.org/ontology/bibo/AudioVisualDocument");

    public static final Resource AuthorList = m_model.createResource(" http://purl.org/ontology/bibo/authorList");

    /**
     * <p>Draft legislation presented for discussion to a legal body.</p>
     */
    public static final Resource Bill = m_model.createResource("http://purl.org/ontology/bibo/Bill");

    /**
     * <p>A written or printed work of fiction or nonfiction, usually on sheets of paper
     * fastened or bound together within covers.</p>
     */
    public static final Resource Book = m_model.createResource("http://purl.org/ontology/bibo/Book");

    /**
     * <p>A section of a book.</p>
     */
    public static final Resource BookSection = m_model.createResource("http://purl.org/ontology/bibo/BookSection");

    /**
     * <p>A written argument submitted to a court.</p>
     */
    public static final Resource Brief = m_model.createResource("http://purl.org/ontology/bibo/Brief");

    /**
     * <p>A chapter of a book.</p>
     */
    public static final Resource Chapter = m_model.createResource("http://purl.org/ontology/bibo/Chapter");

    /**
     * <p>A collection of statutes.</p>
     */
    public static final Resource Code = m_model.createResource("http://purl.org/ontology/bibo/Code");

    /**
     * <p>A document that simultaneously contains other documents.</p>
     */
    public static final Resource CollectedDocument = m_model.createResource("http://purl.org/ontology/bibo/CollectedDocument");

    /**
     * <p>A collection of Documents or Collections</p>
     */
    public static final Resource Collection = m_model.createResource("http://purl.org/ontology/bibo/Collection");

    /**
     * <p>A meeting for consultation or discussion.</p>
     */
    public static final Resource Conference = m_model.createResource("http://purl.org/ontology/bibo/Conference");

    /**
     * <p>A collection of legal cases.</p>
     */
    public static final Resource CourtReporter = m_model.createResource("http://purl.org/ontology/bibo/CourtReporter");

    /**
     * <p>A document (noun) is a bounded physical representation of body of information
     * designed with the capacity (and usually intent) to communicate. A document
     * may manifest symbolic, diagrammatic or sensory-representational information.</p>
     */
    public static final Resource Document = m_model.createResource("http://purl.org/ontology/bibo/Document");

    /**
     * <p>a distinct part of a larger document or collected document.</p>
     */
    public static final Resource DocumentPart = m_model.createResource("http://purl.org/ontology/bibo/DocumentPart");

    /**
     * <p>The status of the publication of a document.</p>
     */
    public static final Resource DocumentStatus = m_model.createResource("http://purl.org/ontology/bibo/DocumentStatus");

    /**
     * <p>An edited book.</p>
     */
    public static final Resource EditedBook = m_model.createResource("http://purl.org/ontology/bibo/EditedBook");

    /**
     * <p>A written communication addressed to a person or organization and transmitted
     * electronically.</p>
     */
    public static final Resource Email = m_model.createResource("http://purl.org/ontology/bibo/Email");

    public static final Resource Event = m_model.createResource("http://purl.org/ontology/bibo/Event");

    /**
     * <p>A passage selected from a larger work.</p>
     */
    public static final Resource Excerpt = m_model.createResource("http://purl.org/ontology/bibo/Excerpt");

    /**
     * <p>aka movie.</p>
     */
    public static final Resource Film = m_model.createResource("http://purl.org/ontology/bibo/Film");

    /**
     * <p>An instance or a session in which testimony and arguments are presented, esp.
     * before an official, as a judge in a lawsuit.</p>
     */
    public static final Resource Hearing = m_model.createResource("http://purl.org/ontology/bibo/Hearing");

    /**
     * <p>A document that presents visual or diagrammatic information.</p>
     */
    public static final Resource Image = m_model.createResource("http://purl.org/ontology/bibo/Image");

    /**
     * <p>A formalized discussion between two or more people.</p>
     */
    public static final Resource Interview = m_model.createResource("http://purl.org/ontology/bibo/Interview");

    /**
     * <p>something that is printed or published and distributed, esp. a given number
     * of a periodical</p>
     */
    public static final Resource Issue = m_model.createResource("http://purl.org/ontology/bibo/Issue");

    /**
     * <p>A periodical of scholarly journal Articles.</p>
     */
    public static final Resource Journal = m_model.createResource("http://purl.org/ontology/bibo/Journal");

    /**
     * <p>A document accompanying a legal case.</p>
     */
    public static final Resource LegalCaseDocument = m_model.createResource("http://purl.org/ontology/bibo/LegalCaseDocument");

    /**
     * <p>A document containing an authoritative determination (as a decree or judgment)
     * made after consideration of facts or law.</p>
     */
    public static final Resource LegalDecision = m_model.createResource("http://purl.org/ontology/bibo/LegalDecision");

    /**
     * <p>A legal document; for example, a court decision, a brief, and so forth.</p>
     */
    public static final Resource LegalDocument = m_model.createResource("http://purl.org/ontology/bibo/LegalDocument");

    /**
     * <p>A legal document proposing or enacting a law or a group of laws.</p>
     */
    public static final Resource Legislation = m_model.createResource("http://purl.org/ontology/bibo/Legislation");

    /**
     * <p>A written or printed communication addressed to a person or organization and
     * usually transmitted by mail.</p>
     */
    public static final Resource Letter = m_model.createResource("http://purl.org/ontology/bibo/Letter");

    /**
     * <p>A periodical of magazine Articles. A magazine is a publication that is issued
     * periodically, usually bound in a paper cover, and typically contains essays,
     * stories, poems, etc., by many writers, and often photographs and drawings,
     * frequently specializing in a particular subject or area, as hobbies, news,
     * or sports.</p>
     */
    public static final Resource Magazine = m_model.createResource("http://purl.org/ontology/bibo/Magazine");

    /**
     * <p>A small reference book, especially one giving instructions.</p>
     */
    public static final Resource Manual = m_model.createResource("http://purl.org/ontology/bibo/Manual");

    /**
     * <p>An unpublished Document, which may also be submitted to a publisher for publication.</p>
     */
    public static final Resource Manuscript = m_model.createResource("http://purl.org/ontology/bibo/Manuscript");

    /**
     * <p>A graphical depiction of geographic features.</p>
     */
    public static final Resource Map = m_model.createResource("http://purl.org/ontology/bibo/Map");

    /**
     * <p>A loose, thematic, collection of Documents, often Books.</p>
     */
    public static final Resource MultiVolumeBook = m_model.createResource("http://purl.org/ontology/bibo/MultiVolumeBook");

    /**
     * <p>A periodical of documents, usually issued daily or weekly, containing current
     * news, editorials, feature articles, and usually advertising.</p>
     */
    public static final Resource Newspaper = m_model.createResource("http://purl.org/ontology/bibo/Newspaper");

    /**
     * <p>Notes or annotations about a resource.</p>
     */
    public static final Resource Note = m_model.createResource("http://purl.org/ontology/bibo/Note");

    /**
     * <p>A document describing the exclusive right granted by a government to an inventor
     * to manufacture, use, or sell an invention for a certain number of years.</p>
     */
    public static final Resource Patent = m_model.createResource("http://purl.org/ontology/bibo/Patent");

    /**
     * <p>A public performance.</p>
     */
    public static final Resource Performance = m_model.createResource("http://purl.org/ontology/bibo/Performance");

    /**
     * <p>A group of related documents issued at regular intervals.</p>
     */
    public static final Resource Periodical = m_model.createResource("http://purl.org/ontology/bibo/Periodical");

    /**
     * <p>A communication between an agent and one or more specific recipients.</p>
     */
    public static final Resource PersonalCommunication = m_model.createResource("http://purl.org/ontology/bibo/PersonalCommunication");

    /**
     * <p>A personal communication manifested in some document.</p>
     */
    public static final Resource PersonalCommunicationDocument = m_model.createResource("http://purl.org/ontology/bibo/PersonalCommunicationDocument");

    /**
     * <p>A compilation of documents published from an event, such as a conference.</p>
     */
    public static final Resource Proceedings = m_model.createResource("http://purl.org/ontology/bibo/Proceedings");

    /**
     * <p>An excerpted collection of words.</p>
     */
    public static final Resource Quote = m_model.createResource("http://purl.org/ontology/bibo/Quote");

    /**
     * <p>A document that presents authoritative reference information, such as a dictionary
     * or encylopedia .</p>
     */
    public static final Resource ReferenceSource = m_model.createResource("http://purl.org/ontology/bibo/ReferenceSource");

    /**
     * <p>A document describing an account or statement describing in detail an event,
     * situation, or the like, usually as the result of observation, inquiry, etc..</p>
     */
    public static final Resource Report = m_model.createResource("http://purl.org/ontology/bibo/Report");

    /**
     * <p>A loose, thematic, collection of Documents, often Books.</p>
     */
    public static final Resource Series = m_model.createResource("http://purl.org/ontology/bibo/Series");

    /**
     * <p>A slide in a slideshow</p>
     */
    public static final Resource Slide = m_model.createResource("http://purl.org/ontology/bibo/Slide");

    /**
     * <p>A presentation of a series of slides, usually presented in front of an audience
     * with written text and images.</p>
     */
    public static final Resource Slideshow = m_model.createResource("http://purl.org/ontology/bibo/Slideshow");

    /**
     * <p>A document describing a standard</p>
     */
    public static final Resource Standard = m_model.createResource("http://purl.org/ontology/bibo/Standard");

    /**
     * <p>A bill enacted into law.</p>
     */
    public static final Resource Statute = m_model.createResource("http://purl.org/ontology/bibo/Statute");

    /**
     * <p>A document created to summarize research findings associated with the completion
     * of an academic degree.</p>
     */
    public static final Resource Thesis = m_model.createResource("http://purl.org/ontology/bibo/Thesis");

    /**
     * <p>The academic degree of a Thesis</p>
     */
    public static final Resource ThesisDegree = m_model.createResource("http://purl.org/ontology/bibo/ThesisDegree");

    /**
     * <p>The shorttitle of</p>
     */
    public static final Resource shortTitle = m_model.createResource("http://purl.org/ontology/bibo/shortTitle");
    /**
     * <p>A web page is an online document available (at least initially) on the world
     * wide web. A web page is written first and foremost to appear on the web, as
     * distinct from other online resources such as books, manuscripts or audio documents
     * which use the web primarily as a distribution mechanism alongside other more
     * traditional methods such as print.</p>
     */
    public static final Resource Webpage = m_model.createResource("http://purl.org/ontology/bibo/Webpage");

    /**
     * <p>A group of Webpages accessible on the Web.</p>
     */
    public static final Resource Website = m_model.createResource("http://purl.org/ontology/bibo/Website");

    /**
     * <p>A seminar, discussion group, or the like, that emphasizes zxchange of ideas
     * and the demonstration and application of techniques, skills, etc.</p>
     */
    public static final Resource Workshop = m_model.createResource("http://purl.org/ontology/bibo/Workshop");

    public static final Resource bdarcus = m_model.createResource("http://purl.org/ontology/bibo/bdarcus");

    /**
     * <p>masters degree in arts</p>
     */
    public static final Resource ma = m_model.createResource("http://purl.org/ontology/bibo/degrees/ma");

    /**
     * <p>masters degree in science</p>
     */
    public static final Resource ms = m_model.createResource("http://purl.org/ontology/bibo/degrees/ms");

    /**
     * <p>PhD degree</p>
     */
    public static final Resource phd = m_model.createResource("http://purl.org/ontology/bibo/degrees/phd");

    public static final Resource fgiasson = m_model.createResource("http://purl.org/ontology/bibo/fgiasson");

    /**
     * <p>Accepted for publication after peer reviewing.</p>
     */
    public static final Resource accepted = m_model.createResource("http://purl.org/ontology/bibo/status/accepted");

    /**
     * <p>Document drafted</p>
     */
    public static final Resource draft = m_model.createResource("http://purl.org/ontology/bibo/status/draft");

    /**
     * <p>Document to be published</p>
     */
    public static final Resource forthcoming = m_model.createResource("http://purl.org/ontology/bibo/status/forthcoming");

    /**
     * <p>Legal document</p>
     */
    public static final Resource legal = m_model.createResource("http://purl.org/ontology/bibo/status/legal");

    /**
     * <p>A document that is not peer reviewed</p>
     */
    public static final Resource nonPeerReviewed = m_model.createResource("http://purl.org/ontology/bibo/status/nonPeerReviewed");

    /**
     * <p>The process by which articles are chosen to be included in a refereed journal.
     * An editorial board consisting of experts in the same field as the author review
     * the article and decide if it is authoritative enough for publication.</p>
     */
    public static final Resource peerReviewed = m_model.createResource("http://purl.org/ontology/bibo/status/peerReviewed");

    /**
     * <p>Published document</p>
     */
    public static final Resource published = m_model.createResource("http://purl.org/ontology/bibo/status/published");

    /**
     * <p>Rejected for publication after peer reviewing.</p>
     */
    public static final Resource rejected = m_model.createResource("http://purl.org/ontology/bibo/status/rejected");

    /**
     * <p>Unpublished document</p>
     */
    public static final Resource unpublished = m_model.createResource("http://purl.org/ontology/bibo/status/unpublished");


    public static final Property _abstract = m_model.createProperty(NS + "abstract");
    public static final Property affirmedBy = m_model.createProperty(NS + "affirmedBy");
    public static final Property annotates = m_model.createProperty(NS + "annotates");
    public static final Property argued = m_model.createProperty(NS + "argued");
    public static final Property asin = m_model.createProperty(NS + "asin");
    public static final Property authorList = m_model.createProperty(NS + "authorList");
    // public static final Property bdarcus = m_model.createProperty(NS + "bdarcus");
    public static final Property chapter = m_model.createProperty(NS + "chapter");
    public static final Property citedBy = m_model.createProperty(NS + "citedBy");
    public static final Property cites = m_model.createProperty(NS + "cites");
    public static final Property coden = m_model.createProperty(NS + "coden");
    public static final Property content = m_model.createProperty(NS + "content");
    public static final Property contributorList = m_model.createProperty(NS + "contributorList");
    public static final Property court = m_model.createProperty(NS + "court");
    public static final Property degree = m_model.createProperty(NS + "degree");
    public static final Property degrees_ma = m_model.createProperty(NS + "degrees/ma");
    public static final Property degrees_ms = m_model.createProperty(NS + "degrees/ms");
    public static final Property degrees_phd = m_model.createProperty(NS + "degrees/phd");
    public static final Property director = m_model.createProperty(NS + "director");
    public static final Property distributor = m_model.createProperty(NS + "distributor");
    public static final Property doi = m_model.createProperty(NS + "doi");
    public static final Property eanucc13 = m_model.createProperty(NS + "eanucc13");
    public static final Property edition = m_model.createProperty(NS + "edition");
    public static final Property editor = m_model.createProperty(NS + "editor");
    public static final Property editorList = m_model.createProperty(NS + "editorList");
    public static final Property eissn = m_model.createProperty(NS + "eissn");
    //public static final Property fgiasson = m_model.createProperty(NS + "fgiasson");
    public static final Property gtin14 = m_model.createProperty(NS + "gtin14");
    public static final Property handle = m_model.createProperty(NS + "handle");
    public static final Property identifier = m_model.createProperty(NS + "identifier");
    public static final Property interviewee = m_model.createProperty(NS + "interviewee");
    public static final Property interviewer = m_model.createProperty(NS + "interviewer");
    public static final Property isbn = m_model.createProperty(NS + "isbn");
    public static final Property isbn10 = m_model.createProperty(NS + "isbn10");
    public static final Property isbn13 = m_model.createProperty(NS + "isbn13");
    public static final Property issn = m_model.createProperty(NS + "issn");
    public static final Property issue = m_model.createProperty(NS + "issue");
    public static final Property issuer = m_model.createProperty(NS + "issuer");
    public static final Property lccn = m_model.createProperty(NS + "lccn");
    public static final Property locator = m_model.createProperty(NS + "locator");
    public static final Property numPages = m_model.createProperty(NS + "numPages");
    public static final Property numVolumes = m_model.createProperty(NS + "numVolumes");
    public static final Property number = m_model.createProperty(NS + "number");
    public static final Property oclcnum = m_model.createProperty(NS + "oclcnum");
    public static final Property organizer = m_model.createProperty(NS + "organizer");
    public static final Property owner = m_model.createProperty(NS + "owner");
    public static final Property pageEnd = m_model.createProperty(NS + "pageEnd");
    public static final Property pageStart = m_model.createProperty(NS + "pageStart");
    public static final Property pages = m_model.createProperty(NS + "pages");
    public static final Property performer = m_model.createProperty(NS + "performer");
    public static final Property pmid = m_model.createProperty(NS + "pmid");
    public static final Property prefixName = m_model.createProperty(NS + "prefixName");
    public static final Property presentedAt = m_model.createProperty(NS + "presentedAt");
    public static final Property presents = m_model.createProperty(NS + "presents");
    public static final Property producer = m_model.createProperty(NS + "producer");
    public static final Property recipient = m_model.createProperty(NS + "recipient");
    public static final Property reproducedIn = m_model.createProperty(NS + "reproducedIn");
    public static final Property reversedBy = m_model.createProperty(NS + "reversedBy");
    public static final Property reviewOf = m_model.createProperty(NS + "reviewOf");
    public static final Property section = m_model.createProperty(NS + "section");
    public static final Property shortDescription = m_model.createProperty(NS + "shortDescription");
    //public static final Property shortTitle = m_model.createProperty(NS + "shortTitle");
    public static final Property sici = m_model.createProperty(NS + "sici");
    public static final Property status = m_model.createProperty(NS + "status");
    public static final Property status_accepted = m_model.createProperty(NS + "status/accepted");
    public static final Property status_draft = m_model.createProperty(NS + "status/draft");
    public static final Property status_forthcoming = m_model.createProperty(NS + "status/forthcoming");
    public static final Property status_legal = m_model.createProperty(NS + "status/legal");
    public static final Property status_nonPeerReviewed = m_model.createProperty(NS + "status/nonPeerReviewed");
    public static final Property status_peerReviewed = m_model.createProperty(NS + "status/peerReviewed");
    public static final Property status_published = m_model.createProperty(NS + "status/published");
    public static final Property status_rejected = m_model.createProperty(NS + "status/rejected");
    public static final Property status_unpublished = m_model.createProperty(NS + "status/unpublished");
    public static final Property subsequentLegalDecision = m_model.createProperty(NS + "subsequentLegalDecision");
    public static final Property suffixName = m_model.createProperty(NS + "suffixName");
    public static final Property transcriptOf = m_model.createProperty(NS + "transcriptOf");
    public static final Property translationOf = m_model.createProperty(NS + "translationOf");
    public static final Property translator = m_model.createProperty(NS + "translator");
    public static final Property upc = m_model.createProperty(NS + "upc");
    public static final Property uri = m_model.createProperty(NS + "uri");
    public static final Property volume = m_model.createProperty(NS + "volume");

}
