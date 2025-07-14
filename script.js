document.addEventListener("DOMContentLoaded", () => {
    try {
        console.log("Initializing animations...");
        locomotiveAnimation();
        curserAnimation();
        loadingAnimation();
        sheryAnimation();
    } catch (error) {
        console.error("Script error:", error);
    }
});

function locomotiveAnimation() {
    const locoScroll = new LocomotiveScroll({
        el: document.querySelector("#main"),
        smooth: true,
        smartphone: { smooth: true },
        tablet: { smooth: true },
    });

    gsap.registerPlugin(ScrollTrigger);

    locoScroll.on("scroll", ScrollTrigger.update);

    ScrollTrigger.scrollerProxy("#main", {
        scrollTop(value) {
            return arguments.length
                ? locoScroll.scrollTo(value, { duration: 0, disableLerp: true })
                : locoScroll.scroll.instance.scroll.y;
        },
        getBoundingClientRect() {
            return {
                top: 0,
                left: 0,
                width: window.innerWidth,
                height: window.innerHeight,
            };
        },
        pinType: document.querySelector("#main").style.transform ? "transform" : "fixed",
    });

    ScrollTrigger.addEventListener("refresh", () => locoScroll.update());
    ScrollTrigger.refresh();
}

function loadingAnimation() {
    console.log("Loading animation started");
    let tl = gsap.timeline();

    tl.from(".line h1", {
        y: 150,
        stagger: 0.25,
        duration: 0.6,
        delay: 0.5,
    });

    tl.from("#line1-part1", {
        opacity: 0,
        onStart: () => {
            let h5timer = document.querySelector("#line1-part1 h5");
            let grow = 0;
            const interval = setInterval(() => {
                if (grow < 100) {
                    h5timer.innerHTML = grow++;
                } else {
                    h5timer.innerHTML = grow;
                    clearInterval(interval);
                }
            }, 33);
        },
    });

    tl.to(".line h2", {
        animationName: "anime",
        opacity: 1,
    });

    tl.to("#page0", {
        opacity: 0,
        duration: 0.2,
        delay: 2.25,
        onComplete: () => console.log("#page0 hidden"),
    });

    tl.set("#page0", {
        display: "none",
        pointerEvents: "none",
    });

    tl.from("#page1", {
        delay: 0.2,
        y: 1600,
        opacity: 0,
        duration: 0.6,
        ease: "power4.out",
    });

    tl.from("#info", {
        y: 100,
        opacity: 0,
        duration: 1,
        ease: "power4.out",
    });

    tl.call(initNewPagesAnimations);
}

function curserAnimation() {
    if (window.matchMedia("(max-width: 768px)").matches) return;

    const cursor = document.querySelector("#curser");
    const moveCursorX = gsap.quickTo(cursor, "x", { duration: 0.2, ease: "power3.out" });
    const moveCursorY = gsap.quickTo(cursor, "y", { duration: 0.2, ease: "power3.out" });

    document.addEventListener("mousemove", (dets) => {
        moveCursorX(dets.x);
        moveCursorY(dets.y);
    });

    Shery.makeMagnet("#nav2 h4", { strength: 0.5, speed: 0.3 });
}

function initNewPagesAnimations() {
    console.log("New pages animations initialized");

    gsap.set(".service-card", { y: 100, opacity: 0 });
    ScrollTrigger.create({
        trigger: "#page2",
        scroller: "#main",
        start: "top 80%",
        end: "top 30%",
        animation: gsap.to(".service-card", {
            y: 0,
            opacity: 1,
            stagger: 0.2,
            duration: 1,
            ease: "power3.out",
            onStart: () => console.log("Page 2 animation triggered"),
        }),
        toggleActions: "play none none none",
    });

    gsap.to(".icon-circle", {
        y: -10,
        duration: 1.5,
        ease: "power1.inOut",
        repeat: -1,
        yoyo: true,
        stagger: 0.1,
    });

    gsap.set(".testimonial", { x: 200, opacity: 0 });
    ScrollTrigger.create({
        trigger: "#page3",
        scroller: "#main",
        start: "top 70%",
        end: "top 20%",
        animation: gsap.to(".testimonial", {
            x: 0,
            opacity: 1,
            stagger: 0.3,
            duration: 1.2,
            ease: "power2.out",
            onStart: () => console.log("Page 3 animation triggered"),
        }),
        toggleActions: "play none none none",
    });

    gsap.set([".contact-description", ".contact-form", ".form-input", ".form-textarea", ".form-submit"], {
        y: 50,
        opacity: 0,
    });
    ScrollTrigger.create({
        trigger: "#page4",
        scroller: "#main",
        start: "top 60%",
        end: "top 10%",
        animation: gsap.to([".contact-description", ".contact-form", ".form-input", ".form-textarea", ".form-submit"], {
            y: 0,
            opacity: 1,
            stagger: 0.1,
            duration: 0.8,
            ease: "power3.out",
            onStart: () => console.log("Page 4 animation triggered"),
        }),
        toggleActions: "play none none none",
    });

    gsap.to(".pattern-element", {
        rotation: 360,
        duration: 30,
        ease: "none",
        repeat: -1,
    });

    const serviceCards = document.querySelectorAll(".service-card");
    serviceCards.forEach((card) => {
        card.addEventListener("mouseenter", function () {
            gsap.to(this, {
                scale: 1.05,
                duration: 0.3,
                ease: "power2.out",
            });
            gsap.to("#curser", {
                scale: 1.5,
                backgroundColor: "rgba(255, 255, 255, 0.1)",
                duration: 0.3,
            });
        });
        card.addEventListener("mouseleave", function () {
            gsap.to(this, {
                scale: 1,
                duration: 0.3,
                ease: "power2.out",
            });
            gsap.to("#curser", {
                scale: 1,
                backgroundColor: "transparent",
                duration: 0.3,
            });
        });
    });

    const formElements = document.querySelectorAll(".form-input, .form-textarea, .form-submit");
    formElements.forEach((element) => {
        element.addEventListener("mouseenter", function () {
            gsap.to("#curser", {
                scale: 1.5,
                backgroundColor: "rgba(255, 255, 255, 0.1)",
                duration: 0.3,
            });
        });
        element.addEventListener("mouseleave", function () {
            gsap.to("#curser", {
                scale: 1,
                backgroundColor: "transparent",
                duration: 0.3,
            });
        });
    });

    document.querySelector(".contact-form").addEventListener("submit", (e) => {
        e.preventDefault();
        console.log("Form submitted");
    });

    setupImageClickNavigation();
}

function sheryAnimation(){
  Shery.imageEffect(".image-div",{
    style : 5,
    gooey : true,
  });
}

function setupImageClickNavigation() {
    const imageDivs = document.querySelectorAll(".image-div");
    imageDivs.forEach(div => {
        const targetUrl = div.getAttribute("data-link");
        if (!targetUrl) return;

        div.style.cursor = "pointer";
        div.addEventListener("click", () => {
            gsap.to("#main", {
                opacity: 0,
                duration: 0.8,
                ease: "power2.inOut",
                onComplete: () => {
                    window.location.href = targetUrl;
                }
            });
        });
    });
}
