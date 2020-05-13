<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- foundation-float.min.css: Compressed CSS with legacy Float Grid -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/foundation-sites@6.6.3/dist/css/foundation-float.min.css" integrity="sha256-4ldVyEvC86/kae2IBWw+eJrTiwNEbUUTmN0zkP4luL4=" crossorigin="anonymous">

<!-- foundation-prototype.min.css: Compressed CSS with prototyping classes -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/foundation-sites@6.6.3/dist/css/foundation-prototype.min.css" integrity="sha256-BiKflOunI0SIxlTOOUCQ0HgwXrRrRwBkIYppEllPIok=" crossorigin="anonymous">

<!-- foundation-rtl.min.css: Compressed CSS with right-to-left reading direction -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/foundation-sites@6.6.3/dist/css/foundation-rtl.min.css" integrity="sha256-F+9Ns8Z/1ZISonBbojH743hsmF3x3AlQdJEeD8DhQsE=" crossorigin="anonymous">
</head>
<body>
<style>
  /*icon styles*/
  .fi-social-facebook {
    color: dodgerblue;
    font-size: 2rem;
  }
  .fi-social-youtube {
    color: red;
    font-size: 2rem;
  }
  .fi-social-pinterest {
    color: darkred;
    font-size: 2rem;
  }
  i.fi-social-instagram {
    color: brown;
    font-size: 2rem;
  }
  i.fi-social-tumblr {
    color: navy;
    font-size: 2rem;
  }
  .fi-social-twitter {
    color: skyblue;
    font-size: 2rem;
  }

</style>

<header>
  <!-- Sub Navigation -->
  <div class="top-bar">
    <div class="top-bar-left">
      <ul class="menu">
        <li><a href="#">One</a></li>
        <li><a href="#">Two</a></li>
        <li><a href="#">Three</a></li>
        <li><a href="#">Four</a></li>
      </ul>
    </div>
    <div class="top-bar-right">
      <ul class="menu">
        <li><input type="search" placeholder="Search"></li>
        <li><button type="button" class="button">Search</button></li>
      </ul>
    </div>
  </div>
  <!-- /Sub Navigation -->
  <br>

  <div class="title-bar" data-responsive-toggle="main-menu" data-hide-for="medium">
    <button class="menu-icon" type="button" data-toggle></button>
    <div class="title-bar-title">Menu</div>
  </div>

  <div class="top-bar" id="main-menu">
    <ul class="menu vertical medium-horizontal expanded medium-text-center" data-responsive-menu="drilldown medium-dropdown">
      <li class="has-submenu"><a href="#">Tech</a>
        <ul class="submenu menu vertical" data-submenu>
          <li><a href="#">One</a></li>
          <li><a href="#">Two</a></li>
          <li><a href="#">Three</a></li>
        </ul>
      </li>
      <li class="has-submenu"><a href="#">Energy</a>
        <ul class="submenu menu vertical" data-submenu>
          <li><a href="#">One</a></li>
          <li><a href="#">Two</a></li>
          <li><a href="#">Three</a></li>
        </ul>
      </li>
      <li class="has-submenu"><a href="#">Space</a>
        <ul class="submenu menu vertical" data-submenu>
          <li><a href="#">One</a></li>
          <li><a href="#">Two</a></li>
          <li><a href="#">Three</a></li>
        </ul>
      </li>
      <li class="has-submenu"><a href="#">Medicine</a>
        <ul class="submenu menu vertical" data-submenu>
          <li><a href="#">One</a></li>
          <li><a href="#">Two</a></li>
          <li><a href="#">Three</a></li>
        </ul>
      </li>
      <li class="has-submenu"><a href="#">Robotics</a>
        <ul class="submenu menu vertical" data-submenu>
          <li><a href="#">One</a></li>
          <li><a href="#">Two</a></li>
          <li><a href="#">Three</a></li>
        </ul>
      </li>
      <li class="has-submenu"><a href="#">Tesla</a>
        <ul class="submenu menu vertical" data-submenu>
          <li><a href="#">One</a></li>
          <li><a href="#">Two</a></li>
          <li><a href="#">Three</a></li>
        </ul>
      </li>
    </ul>
  </div>

</header>

<br>

<div class="row">
  <div class="medium-8 columns">
    <p><img src="https://placehold.it/900x450&text=Promoted Article" alt="main article image"></p>
  </div>
  <div class="medium-4 columns">
    <p><img src="https://placehold.it/400x200&text=Other cool article" alt="article promo image" alt="advertisement for deep fried Twinkies"></p>
    <p><img src="https://placehold.it/400x200&text=Other cool article" alt="article promo image"></p>
  </div>
</div>

<hr>

<div class="row column">
  <h4 style="margin: 0;" class="text-center">BREAKING NEWS</h4>
</div>

<hr>

<div class="row small-up-3 medium-up-4 large-up-5">

  <div class="column">
    <img src="https://placehold.it/400x370&text=Look at me!" alt="image for article">
  </div>

  <div class="column">
    <img src="https://placehold.it/400x370&text=Look at me!" alt="image for article">
  </div>

  <div class="column">
    <img src="https://placehold.it/400x370&text=Look at me!" alt="image for article">
  </div>

  <div class="column show-for-medium">
    <img src="https://placehold.it/400x370&text=Look at me!" alt="image for article">
  </div>

  <div class="column show-for-large">
    <img src="https://placehold.it/400x370&text=Look at me!" alt="image for article">
  </div>

</div>

<hr>

<div class="row column">
  <h4 style="margin: 0;" class="text-center">LATEST STORIES</h4>
</div>

<hr>

<div class="row">
  <div class="large-8 columns" style="border-right: 1px solid #E3E5E8;">

  <article>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">'Death Star' Vaporizes Its Own Planet</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">NASA's SLS Rocket Sheds Saturn V Color Scheme in Design Review</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">Ingredients for Life Were Always Present on Earth, Comet Suggests</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">Astronaut's Watch Worn on the Moon Sells for Record $1.6 Million</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">Interstellar Dust on the Galaxy's Magnetic Field | Space Wallpaper</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">Explore the Moon (Virtually) with These Awesome Global Maps</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <div class="row">
      <div class="large-6 columns">
        <p><img src="https://placehold.it/600x370&text=Look at me!" alt="image for article" alt="article preview image"></p>
      </div>
      <div class="large-6 columns">
        <h5><a href="#">Best Space Books and Sci-Fi: A Space.com Reading List</a></h5>
        <p>
          <span><i class="fi-torso"> By Thadeus &nbsp;&nbsp;</i></span>
          <span><i class="fi-calendar"> 11/23/16 &nbsp;&nbsp;</i></span>
          <span><i class="fi-comments"> 6 comments</i></span>
        </p>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae impedit beatae, ipsum delectus aperiam nesciunt magni facilis ullam.</p>
      </div>
    </div>

    <hr>

    <ul class="pagination" role="navigation" aria-label="Pagination">
      <li class="disabled">Previous <span class="show-for-sr">page</span></li>
      <li class="current"><span class="show-for-sr">You're on page</span> 1</li>
      <li><a href="#" aria-label="Page 2">2</a></li>
      <li><a href="#" aria-label="Page 3">3</a></li>
      <li><a href="#" aria-label="Page 4">4</a></li>
      <li><a href="#" aria-label="Next page">Next <span class="show-for-sr">page</span></a></li>
    </ul>

    </article>

  </div>

  <div class="large-4 columns">

    <aside>

      <div class="row small-up-3">

        <div class="column text-center">
          <i class="fi-social-facebook"></i>
          <h6>56,009</h6>
          <p><small>FOLLOWERS</small></p>
          <br>
        </div>

        <div class="column text-center">
          <i class="fi-social-twitter"></i>
          <h6>76,905</h6>
          <p><small>FOLLOWERS</small></p>
          <br>
        </div>

        <div class="column text-center">
          <i class="fi-social-instagram"></i>
          <h6>34,099</h6>
          <p><small>FOLLOWERS</small></p>
          <br>
        </div>

        <div class="column text-center">
          <i class="fi-social-tumblr"></i>
          <h6>13,765</h6>
          <p><small>FOLLOWERS</small></p>
        </div>

        <div class="column text-center">
          <i class="fi-social-pinterest"></i>
          <h6>9,283</h6>
          <p><small>FOLLOWERS</small></p>
        </div>

        <div class="column text-center">
          <i class="fi-social-youtube"></i>
          <h6>99,000</h6>
          <p><small>FOLLOWERS</small></p>
        </div>

      </div>

      <br>

      <div class="row column">
        <p class="lead">FROM OUR FRIENDS</p>
        <p><img src="https://placehold.it/400x300&text=Buy Me!" alt="advertisement of ShamWow"></p>
      </div>

      <br>

      <div class="row column">
        <p class="lead">TRENDING POSTS</p>

        <div class="media-object">
          <div class="media-object-section">
            <img class="thumbnail" src= "https://placehold.it/100">
          </div>
          <div class="media-object-section">
            <h5>All I need is a space suit and I'm ready to go.</h5>
          </div>
        </div>

        <div class="media-object">
          <div class="media-object-section">
            <img class="thumbnail" src= "https://placehold.it/100">
          </div>
          <div class="media-object-section">
            <h5>Are the stars out tonight? I don't know if it's cloudy or bright.</h5>
          </div>
        </div>

        <div class="media-object">
          <div class="media-object-section">
            <img class="thumbnail" src= "https://placehold.it/100">
          </div>
          <div class="media-object-section">
            <h5>And the world keeps spinning.</h5>
          </div>
        </div>

        <div class="media-object">
          <div class="media-object-section">
            <img class="thumbnail" src= "https://placehold.it/100">
          </div>
          <div class="media-object-section">
            <h5>Cold hearted orb that rules the night.</h5>
          </div>
        </div>

      </div>

    </aside>

  </div>
</div>
</body>
</html>