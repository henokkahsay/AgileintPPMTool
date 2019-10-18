import React, { Component } from "react";
import ProjectItem from "./Project/ProjectItem";
import CreatProjectButton from "./Project/CreatProjectButton";

class Dashboard extends Component {
  render() {
    return (
      <div class="projects">
        <div class="container">
          <div class="row">
            <div class="col-md-12">
              <h1 class="display-4 text-center">Projects</h1>
              <br />
              <CreatProjectButton />
              <br />
              <hr />
              <ProjectItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default Dashboard;
