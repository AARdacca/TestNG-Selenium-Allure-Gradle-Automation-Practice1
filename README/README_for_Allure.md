### 📊 Generate and Serve Allure Report

After running your tests and generating the `allure-results`, follow these steps to view the test report:

#### ✅ Combined Command to Generate and Serve the Report:

```bash
allure generate allure-results --clean -output
allure serve allure-results
```

* `--clean`: Clears any previous report data before generating a new one.
* `-o build/allure-report`: Outputs the report into the `build/allure-report` folder.
* `allure open`: Opens the generated report in your default browser.

---

### 🔃 Optional: Clean Previous Results (if needed)

If you want to remove previously generated report folders before a fresh test run:

```bash
rm -rf build/allure-results build/allure-report
```

This ensures a clean slate before generating new Allure data.
